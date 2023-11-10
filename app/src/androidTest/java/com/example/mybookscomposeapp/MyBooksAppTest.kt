package com.example.mybookscomposeapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.mybookscomposeapp.data.BookData
import com.example.mybookscomposeapp.ui.navigation.Screen
import com.example.mybookscomposeapp.ui.theme.MyBooksComposeAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MyBooksAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyBooksComposeAppTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                MyBooksApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailWithData() {
        composeTestRule.onNodeWithTag("BookList").performScrollToIndex(5)
        composeTestRule.onNodeWithText(BookData.dummyBooks[5].synopsis)
            .assertIsDisplayed()
            .performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithText(BookData.dummyBooks[5].synopsis).assertIsDisplayed()
    }

    @Test
    fun navHost_bottomNavigation_working() {
        composeTestRule.onNodeWithStringId(R.string.menu_favorite).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithStringId(R.string.menu_about).performClick()
        navController.assertCurrentRouteName(Screen.About.route)
        composeTestRule.onNodeWithStringId(R.string.menu_home).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesBack() {
        composeTestRule.onNodeWithTag("BookList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(BookData.dummyBooks[10].bookTitle).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back))
            .performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun about_page_displayedProperly() {
        composeTestRule.onNodeWithStringId(R.string.menu_about).performClick()
        navController.assertCurrentRouteName(Screen.About.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.nanda_image))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.name))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.email))
            .assertIsDisplayed()
    }

    @Test
    fun checkemptyfavoriteBooks_addFavoriteBook_checkfavoriteList() {
        composeTestRule.onNodeWithStringId(R.string.menu_favorite).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.list_empty_message))
            .assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.menu_home).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)

        composeTestRule.onNodeWithTag("BookList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(BookData.dummyBooks[10].synopsis)
            .assertIsDisplayed()
            .performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithText(BookData.dummyBooks[10].synopsis).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.favorite_button))
            .performClick()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back))
            .performClick()

        composeTestRule.onNodeWithStringId(R.string.menu_favorite).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithText(BookData.dummyBooks[10].synopsis).assertIsDisplayed()
    }

    @Test
    fun searchBar_searchbook_Found() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.search_book))
            .performTextInput(BookData.dummyBooks[7].bookTitle)
        composeTestRule.onNodeWithTag("BookList").assertIsDisplayed()
        composeTestRule.onNodeWithText(BookData.dummyBooks[7].synopsis).assertIsDisplayed()
    }

    @Test
    fun searchBar_searchbook_notFound() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.search_book))
            .performTextInput("Buku Fisika")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.list_empty_message))
            .assertIsDisplayed()
    }

    @Test
    fun addBook_fillform_addnewBook() {
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.add_book_button))
            .performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_url_book_cover))
            .performTextInput("https://cdn.gramedia.com/uploads/items/9786022778134.jpg")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_book_title))
            .performTextInput("Buku Sakti Astronomi")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_author_name))
            .performTextInput("TOASTI")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_publication_year))
            .performTextInput("2015")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_category))
            .performTextInput("Buku Pelajaran")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.enter_synopsis))
            .performTextInput(
                "Buku Sakti Olimpiade Astronomi ini merupakan lokomotif yang mengawali rangkaian buku penunjang persiapan siswa untuk mengikuti olimpiade astronomi dari tingkat paling bawah hingga tingkat internasional. Buku ini berisikan materi yang disa-jikan secara komprehensif, disertai ilustrasi yang memadai, dan dilengkapi dengan beberapa latihan soal yang dapat menguji pemahaman dan merangsang pemikiran analitik siswa. Dibandingkan buku-buku yang telah beredar di pasaran, buku ini memiliki beberapa keunggulan. Pertama, buku ini memi-liki cakupan materi yang lebih luas, dari astrometri (pengukuran posisi) hingga kosmologi (ilmu semesta). Kedalaman materi yang dibahas dalam buku ini telah disesuaikan dengan kebutuhan siswa dalam menghadapi tantangan-tantangan dalam ajang olimpiade. Pengalaman para penulis dalam mengikuti setiap tahapan seleksi olimpiade astronomi memberikan nilai lebih pada buku ini. Selain untuk mendukung olimpiade astronomi, buku ini juga diharapkan dapat menjadi rujukan bagi siswa atau maha-siswa yang ingin mengenal astronomi sebelum menyelaminya lebih dalam."
            )
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.add_book))
    }
}
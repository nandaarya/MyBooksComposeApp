package com.example.mybookscomposeapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mybookscomposeapp.ui.theme.MyBooksComposeAppTheme

@Composable
fun BookItem(
    photoUrl: String,
    bookTitle: String,
    synopsis: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ) {
        Row(
            modifier = modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp, 120.dp)
            )
            WidthSpacer(8.dp)
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = bookTitle,
                    style = MaterialTheme.typography.titleMedium
                )
                HeightSpacer(16.dp)
                Text(
                    text = synopsis,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BookItemPreview() {
    MyBooksComposeAppTheme {
        BookItem(
            "https://upload.wikimedia.org/wikipedia/commons/4/4b/Sebuah-seni-untuk-bersikap-bodoh-amat.jpg",
            "Seni Bersikap Bodo Amat",
            "Seni Bersikap Bodo Amat (The Subtle Art of Not Giving a F*ck) adalah buku yang menawarkan perspektif radikal tentang mencari makna dan kebahagiaan dalam hidup. Ditulis oleh Mark Manson, buku ini menantang pandangan konvensional tentang pencapaian dan kebahagiaan dengan mengajukan pertanyaan penting: Apa yang benar-benar penting dalam hidup kita? Buku ini menunjukkan bahwa fokus pada segala hal yang positif dan mencari kesenangan semata dapat mengakibatkan kekecewaan dan ketidakpuasan." +
                    "Manson mengajak pembaca untuk menghadapi kenyataan dan menerima ketidaksempurnaan diri. Dengan bahasa yang lugas dan berani, ia mengajarkan bagaimana mengalihkan perhatian dari hal-hal yang kurang berarti dan merangkul ketidakpastian. Buku ini membahas tentang memilih nilai-nilai yang benar-benar penting dalam hidup, memperkuat keterampilan menghadapi masalah, dan mengembangkan rasa keterikatan dengan diri sendiri dan orang lain. Dengan pendekatan yang menghibur dan penuh wawasan, buku ini mengajak pembaca untuk menjalani kehidupan yang lebih otentik, tulus, dan penuh makna."
        )
    }
}
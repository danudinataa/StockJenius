package com.ramaa.pmobile_uas.presentation.news.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ramaa.pmobile_uas.R
import com.ramaa.pmobile_uas.data.remote.response.ResultsNewsItem
import com.ramaa.pmobile_uas.util.Constants.IMAGE_NOT_FOUND
import com.ramaa.pmobile_uas.util.Dimens.CharacterCardSize
import com.ramaa.pmobile_uas.util.Dimens.ExtraSmallPadding
import com.ramaa.pmobile_uas.util.Dimens.SmallPadding1

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    itemNews: ResultsNewsItem,
    onClick: (() -> Unit)? = null
) {

    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() }
    ) {
        AsyncImage(
            modifier = Modifier
                .size(CharacterCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(
                itemNews.image ?: IMAGE_NOT_FOUND
            ).build(),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(SmallPadding1))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(CharacterCardSize)
                .align(Alignment.CenterVertically)
        ) {
            itemNews.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleSmall.copy(),
                    color = colorResource(id = R.color.text_title),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            itemNews.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.body),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterCard() {
    val sampleItemCharacter = ResultsNewsItem(
        title = "Solusi Lifestyle Mudah! Bank Mandiri-JCB Gelar Festival Menarik Ini",
        image = "https://awsimages.detik.net.id/visual/2024/06/01/dok-bank-mandiri_169.jpeg?w=650",
        description = "Bank Mandiri dan JCB telah berkolaborasi dalam menyajikan rangkaian Mandiri JCB Precious Festival 2024"
    )
    NewsCard(
        modifier = Modifier.padding(16.dp),
        itemNews = sampleItemCharacter,
        onClick = { /* Handle click */ }
    )
}
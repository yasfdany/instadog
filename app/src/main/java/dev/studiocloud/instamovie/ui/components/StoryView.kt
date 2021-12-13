package dev.studiocloud.instamovie.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import dev.studiocloud.instamovie.BuildConfig
import dev.studiocloud.instamovie.data.remote.response.tvResponse.TvItem

@Composable
fun StoryView(
    tvs: SnapshotStateList<TvItem>,
    onTapStory: (index: Int, selected: TvItem) -> Unit
){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 14.dp,
            ),
        contentPadding = PaddingValues(horizontal = 14.dp)
    ) {
        itemsIndexed(tvs){ index, tv ->
            Surface(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .border(color = Color.Magenta, width = 2.dp, shape = CircleShape)
            ) {
                Image(
                    painter = rememberImagePainter(
                        BuildConfig.IMAGE_BASE_URL+"w342/"+tv.posterPath,
                        builder = {
                            crossfade(true)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(54.dp)
                        .clip(CircleShape)
                        .clickable {
                            onTapStory(index, tv)
                        }
                )
            }
        }
    }
}
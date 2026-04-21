package com.kingslayer06.core.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingslayer06.core.ui.Background
import com.kingslayer06.core.ui.TextPrimary
import com.kingslayer06.core.ui.interFontFamily

private data class NavigationItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(
    selectedRoute: String,
    onSelected: (String) -> Unit
) {
    val navigationItems = listOf(
        NavigationItem("Home", Icons.Default.Home),
        NavigationItem("Explore", Icons.Default.Search),
        NavigationItem("My Library", Icons.Default.Folder)
    )

    NavigationBar(
        containerColor = Background,
        modifier = Modifier
            .height(108.dp)
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationItems.forEach { item ->
                val isSelected = selectedRoute == item.label
                val color = if (isSelected) TextPrimary else TextPrimary.copy(alpha = 0.5f)

                Column(
                    modifier = Modifier
                        .clickable { onSelected(item.label) }
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = color
                    )

                    Text(
                        text = item.label,
                        color = color,
                        fontFamily = interFontFamily,
                        fontSize = 15.sp,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBottomNavigationBar() {
    val selectedRoute = remember {
        mutableStateOf("Home")
    }

    BottomNavigationBar(
        selectedRoute = selectedRoute.value,
        onSelected = { selectedRoute.value = it }
    )
}
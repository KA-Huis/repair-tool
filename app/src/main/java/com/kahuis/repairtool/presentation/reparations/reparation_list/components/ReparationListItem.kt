package com.kahuis.repairtool.presentation.reparations.reparation_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kahuis.repairtool.domain.model.Reparation

@Composable
fun RepairListItem(
    repair: Reparation,
    onItemClick: (Reparation) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(repair) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SelectionContainer {
            Text(
                text = repair.title + " (${repair.location})",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body1,
                fontWeight = Bold,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Text(
            text = repair.status,
            color = MaterialTheme.colors.secondary,
            fontStyle = Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
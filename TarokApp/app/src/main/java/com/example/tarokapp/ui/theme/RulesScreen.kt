package com.example.tarokapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarokapp.ui.theme.TarokAppTheme

@Composable
fun RulesScreen(onBack: () -> Unit) {
    var isEnglish by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF4F4F9),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Language Toggle Button
            Button(
                onClick = { isEnglish = !isEnglish },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4757))
            ) {
                Text(if (isEnglish) "SLO" else "ENG", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Title
            Text(
                text = if (isEnglish) "How to Count Points in Tarok" else "Kako šteti točke v Taroku",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Scoring Section
            Text(
                text = if (isEnglish) "The Scoring" else "Točkovanje",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = if (isEnglish) {
                    "A cumulative score is kept on paper. In most cases, only the declarer (and their partner, if any) score. Solidarity of partnerships applies, meaning if the declarer has a partner, both members win or lose the same amount."
                } else {
                    "Skupna ocena se vodi na papirju. V večini primerov točke beleži le napovedovalec (in njegov partner, če ga ima). Velja načelo solidarnosti partnerjev, kar pomeni, da oba člana zmagata ali izgubita enako število točk."
                }
            )
            Text(
                text = if (isEnglish) {
                    "Klop: Everyone scores separately."
                } else {
                    "Klop: Vsak igralec beleži točke posebej."
                }
            )
            Text(
                text = if (isEnglish) {
                    "The penalty for losing the Mond applies only to the player who lost it."
                } else {
                    "Kazni za izgubo Monda se nanašajo le na igralca, ki ga je izgubil."
                }
            )
            Text(
                text = if (isEnglish) {
                    "Penalties for revoking, misdealing, etc., apply only to the culprit."
                } else {
                    "Kazni za napačno igranje, napačno deljenje itd., se nanašajo le na kršitelja."
                }
            )
            Text(
                text = if (isEnglish) {
                    "The point value of the contract is added to the player's score if they win or subtracted if they lose. For normal contracts, this value is increased by the card point difference, calculated as:"
                } else {
                    "Vrednost pogodbe se prišteje k igralčevim točkam, če zmaga, ali odšteje, če izgubi. Pri običajnih pogodbah se ta vrednost poveča za razliko v točkah kart, kar se izračuna:"
                }
            )
            Text(
                text = if (isEnglish) {
                    "Difference = (Card points won - 35), rounded to the nearest 5."
                } else {
                    "Razlika = (Točke kart - 35), zaokroženo na najbližjih 5."
                }
            )


            Spacer(modifier = Modifier.height(20.dp))

            // Back Button
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A5A5A))
            ) {
                Text("Back", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

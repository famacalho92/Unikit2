package com.example.unikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.unikit.ui.theme.UnikitTheme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = "https://vhbutrkzjibajrwtofhm.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZoYnV0cmt6amliYWpyd3RvZmhtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTE4MzU3OTMsImV4cCI6MjAyNzQxMTc5M30.HHwr7GJ9mYPuDUvV1EAvi4nuDomVWZYUyK8t_BW-pUE"
) {
    install(Postgrest)
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnikitTheme {
                UnikitApp()
            }
        }
    }
}

@Composable
fun UnikitApp() {
    val navController = rememberNavController() // Crea una instancia de NavController
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController) }
        composable("menu_screen") { MenuScreen(navController = navController) }
        composable("horario_screen") { HorarioScreen(navController = navController) }
        composable("agenda_screen") { AgendaScreen(navController = navController) }
        composable("cuaderno_screen") { CuadernoScreen(navController = navController) }
        composable("ajustes_screen") { AjustesScreen(navController = navController) }
        composable("Creditos_Screen") { Creditos_screen(navController = navController) }

    }
}

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//             Image(
//                            painter = painterResource(id = R.mipmap.ic_launcher ), //no carga imagen
//                            contentDescription = "Imagen creditos"
//                        )
            Card(
                modifier = Modifier.padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Unikit", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = "Ingresa tu correo electrónico",
                        onValueChange = {},
                        label = { Text("Correo electrónico") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = "Ingresa tu contraseña",
                        onValueChange = {},
                        label = { Text("Contraseña") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            //function auth
                            //conection DB
                            //comparacion de credenciales y auth inicio sesion
                            navController.navigate("menu_screen") // navigate to home screen (original behavior)
                        }
                    ) {
                        Text("Iniciar sesión")
                    }

                }
            }
        }
    }
}

@Composable
fun MenuScreen(navController: NavController) {
    // ... Add your desired UI elements for the new screen here ...

    // Example content:
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Unikit")
            Text(text = "Universidad del Cauca Kit")

            Button(
                onClick = {
                    navController.navigate("horario_screen") // Handle button click on new screen (optional)
                }
            ) {
                Text("Horario de Clases ")
            }
            Button(
                onClick = {
                    navController.navigate("agenda_screen")   // Handle button click on new screen (optional)
                }
            ) {
                Text("Agenda")
            }
            Button(
                onClick = {
                    navController.navigate("cuaderno_screen")  // Handle button click on new screen (optional)
                }
            ) {
                Text("Cuaderno")
            }
            Button(
                onClick = {
                    navController.navigate("ajustes_screen")  // Handle button click on new screen (optional)
                }
            ) {
                Text("Ajustes")
            }
            Button(
                onClick = {
                    navController.navigate("LoginScreen")   // Handle button click on new screen (optional)
                }
            ) {
                Text("Cerrar sesión")
            }
        }
    }
}
@Composable
fun HorarioScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Horario de Clases", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            // Bucle para mostrar las horas de clase
            for (franjaHoraria in obtenerHorario()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = franjaHoraria.first, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = franjaHoraria.second, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

// Función para definir el horario de clases
private fun obtenerHorario(): List<Pair<String, String>> {
    val dias = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
    val duracionClase = 2 // Horas

    return dias.flatMap { dia ->
        listOf(
            Pair("$dia 7:00 AM", "$dia ${7 + duracionClase}:00 AM"),  // Lunes 7:00 AM - 9:00 AM
            Pair("$dia ${7 + duracionClase}:00 AM", "$dia ${7 + 2 * duracionClase}:00 AM"), // Lunes 9:00 AM - 11:00 AM
            Pair("$dia ${7 + 2 * duracionClase}:00 PM", "$dia ${7 + 3 * duracionClase}:00 PM"), // Lunes 2:00 PM - 4:00 PM
            Pair("$dia ${7 + 3 * duracionClase}:00 PM", "$dia ${7 + 4 * duracionClase}:00 PM"), // Lunes 4:00 PM - 6:00 PM
            Pair("$dia ${7 + 4 * duracionClase}:00 PM", "$dia 8:00 PM"),  // Lunes 6:00 PM - 8:00 PM
        )
    }
}
@Composable
fun AgendaScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Agenda Diaria", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            // Display agenda items
            for (agendaItem in getAgenda()) {
                AgendaItem(agendaItem = agendaItem)
            }
        }
    }
}

// Define the data structure for an agenda item
data class AgendaItem(val time: String, val title: String, val details: String? = null)

// Function to define the sample daily agenda
private fun getAgenda(): List<AgendaItem> {
    return listOf(
        AgendaItem("7:00 AM", "Clases","Calculo3"),
        AgendaItem("9:00 AM", "Clases", "Aplimovil"),
        AgendaItem("11:30 AM", "Clases", "Laboratorio Serv Tel"),
        AgendaItem("1:00 PM", "Receso"),
        AgendaItem("2:00 PM", "Clases", "Laboratorio Sist Tel"),
        AgendaItem("4:00 PM", "Estudio individual"),
        AgendaItem("6:00 PM", "Receso"),
        AgendaItem("7:00 PM", "Redes"),
        AgendaItem("9:00 PM", "Tiempo libre"),

        )
}

// Composable for displaying a single agenda item
@Composable
fun AgendaItem(agendaItem: AgendaItem) {

    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = agendaItem.time, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Text(text = agendaItem.title, style = MaterialTheme.typography.bodyMedium)
            if (agendaItem.details != null) {
                // Importa el estilo caption
                Text(text = agendaItem.details, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
    Divider(modifier = Modifier.fillMaxWidth())
}
@Composable
fun CuadernoScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Cuaderno" , style = MaterialTheme.typography.headlineMedium)

        }
    }
    Button(
        onClick = {
            navController.navigate("add_book") // Handle button click on new screen (optional)
        }
    ) {
        Text("Añadir nuevo Cuaderno")
    }
    /*Column(modifier = modifier.padding(16.dp)) {
        // Changes to count are now tracked by Compose
        val count: MutableState<Int> = mutableStateOf(0)

        Text("You've had ${count.value} book.")
        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp)) {
            Text("Add book")
        }
    }
*/
}
@Composable
fun AjustesScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Ajustes Unikit ")
            Text(text = "Seguridad")

            Button(
                onClick = {
                    navController.navigate("horario_screen") // Handle button click on new screen (optional)
                }
            ) {
                Text("Cambiar contraseña")
            }
            Button(
                onClick = {
                    navController.navigate("agenda_screen")   // Handle button click on new screen (optional)
                }
            ) {
                Text("Usar Huella para Ingresar")
            }
            Text(text = "Notificaciones")
            Button(
                onClick = {
                    navController.navigate("cuaderno_screen")  // Handle button click on new screen (optional)
                }
            ) {
                Text("Notificaciones de Clases")
            }
            Button(
                onClick = {
                    navController.navigate("ajustes_screen")  // Handle button click on new screen (optional)
                }
            ) {
                Text("Notificaciones de eventos")
            }
            Text(text = "Otros ajustes")
            Button(
                onClick = {
                    navController.navigate("LoginScreen")   // Handle button click on new screen (optional)
                }
            ) {
                Text("Ajustes de Idiomas")
            }
            Button(
                onClick = {
                    navController.navigate("Creditos_Screen")   // Handle button click on new screen (optional)
                }
            ) {
                Text("Acerca de nosotros")
            }
        }
    }
}


@Composable
fun Creditos_screen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
           /* Image(
                painter = painterResource(id = R.mipmap.ic_launcher_round), // Reemplaza con el ID de tu recurso de imagen
                contentDescription = "Imagen creditos"
            )*/
            Text(text = "Integrantes" , style = MaterialTheme.typography.headlineMedium)
            Text(text = "F.Mauricio Calvache Hoyos ")//, style = MaterialTheme.typography.headlineMedium)
            Text(text = "famacalho@unicauca.edu.co")//, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Cristian Serna ")//, style = MaterialTheme.typography.headlineMedium)
            Text(text = "cserna@unicauca.edu.co")//, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Universidad del Cauca")//, style = MaterialTheme.typography.headlineMedium)
            Text(text = "FIET")//, style = MaterialTheme.typography.headlineMedium)
            Text(text = "2024")//, style = MaterialTheme.typography.headlineMedium)
            /* Image(
                            painter = painterResource(id = R.mipmap.ic_launcher_round), //no carga imagen
                            contentDescription = "Imagen creditos"
                        )*/
        }
    }

}

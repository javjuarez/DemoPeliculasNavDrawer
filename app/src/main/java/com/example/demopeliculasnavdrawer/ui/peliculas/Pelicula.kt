package com.example.demopeliculasnavdrawer.ui.peliculas

import com.example.demopeliculasnavdrawer.R

data class Pelicula(var id: Long, var titulo: String, var resumen: String, var generos: String, var imagen: Int, var trailer: Int) {

    companion object {
        fun generateData(): ArrayList<Pelicula> {
            return arrayListOf(
                Pelicula(
                    1,
                    "Sonic the Hedgehog 2",
                    "Después de establecerse en Green Hills, Sonic está ansioso por demostrar que tiene lo que se necesita para ser un verdadero héroe. Su prueba llega cuando el Dr. Robotnik regresa, esta vez con un nuevo compañero, Knuckles, en busca de una esmeralda que tiene el poder de destruir civilizaciones. Sonic se une a su propio compañero, Tails, y juntos se embarcan en un viaje por el mundo para encontrar la esmeralda antes de que caiga en las manos equivocadas.",
                    "Acción, Ciencia ficción, Comedia, Familia",
                    R.drawable.sonic_poster,
                    R.raw.sonic_2
                ),
                Pelicula(
                    2,
                    "Animales fantásticos: Los secretos de Dumbledore",
                    "El profesor Albus Dumbledore sabe que el poderoso mago oscuro Gellert Grindelward se está moviendo para ganar control del mundo mágico. Incapaz de detenerlo por sí solo, le confía al magizoologista Newt Scamander que lidere un intrépido grupo de magos, brujas y un valiente panadero muggle en una aventura peligrosa donde se encontrarán con nuevas y viejas bestias mientras chocan con los seguidores de Grindelwald.",
                    "Fantasía, Aventura",
                    R.drawable.dumbledore,
                    R.raw.dumbledore
                ),
                Pelicula(
                    3,
                    "Morbius",
                    "Gravemente enfermo con un trastorno sanguíneo poco común y decidido a salvar a otros que sufren de ese mismo destino, el Dr. Morbius hace una arriesgada apuesta. Si bien al principio, parece ser un éxito radical, una oscuridad dentro de él se desata. ¿El bien prevalecerá sobre el mal o Morbius sucumbirá a sus misteriosos nuevos impulsos?",
                    "Acción, Ciencia ficción, Fantasía",
                    R.drawable.morbius,
                    R.raw.morbius
                ),
                Pelicula(
                    4,
                    "El Sastre de la Mafia",
                    "Leonard (Rylance), es un sastre inglés que confeccionaba trajes en la mundialmente famosa Savile Row de Londres. Después de una tragedia personal termina en Chicago, trabajando en una pequeña sastrería en una zona difícil de la ciudad donde hace ropa elegante para las únicas personas a su alrededor que pueden pagarla: una familia de gángsters. Esta familia de mafiosos intentará aprovecharse de la naturaleza gentil y complaciente de Leonard, que junto a su asistenta Mable (Zoey Deutch) se verá implicado con la mafia de una manera cada vez más grave.",
                    "Drama, Suspense, Crimen",
                    R.drawable.sastre_mafia,
                    R.raw.sastre_mafia
                )
            )
        }
    }

}

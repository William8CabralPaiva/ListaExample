package com.example.listaexample.data

import com.example.listaexample.model.News

object DataSource {
    fun buildSimpleList() = listOf(
        News(
            0,
            "Android 13: Google anuncia as funções esperadas da atualização",
            "O Android 13 teve seus primeiros detalhes revelados oficialmente nesta quinta-feira (10) pelo Google. O sistema operacional trará melhorias de privacidade, e algumas das funções anunciadas para o update também serão disponibilizadas para Androids mais antigos por meio das atualizações do Google Play.",
            "Beatriz Cardoso",
            "https://s2.glbimg.com/0YSMdkIamRT9l-xpwgWw1XaMxGw=/0x0:1023x682/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/3/A/1qktnBQbK2x5HxyxSEBA/android-11.jpg"
        ),
        News(
            1,
            "Redmi 10 começa a receber MIUI 13 Global baseada em Android 12",
            "Acompanhando o cronograma anunciado pela Xiaomi em janeiro, o MIUI 13 Global começou a ser liberado para diversos aparelhos durante esse primeiro trimestre de 2022 e, agora, foi a vez do Redmi 10 receber a nova interface. Este é um dos primeiros modelos na faixa de entrada a receber o sistema",
            "Tudo Celular",
            "https://t2.tudocdn.net/589300?w=660&h=229"
        ),
        News(
            2,
            "Android 13: Google lança a primeira prévia do sistema operacional para desenvolvedores",
            "Nesta quinta-feira (10), o Google liberou a primeira prévia para desenvolvedores da próxima versão do seu sistema operacional, o Android 13, nomenclatura que também foi oficializada. A previsão da empresa é lançar o SO após agosto deste ano.\n" +
                    "\n" +
                    "De acordo com o Goole, apenas os desenvolvedores que possuem um dispositivo da linha Pixel (a partir da série 4) podem ter acesso neste momento. A empresa disse ainda que vai trabalhar com outras fabricantes para oferecer compilações em breve.",
            "Tudo Celular",
            "https://t2.tudocdn.net/610745?w=660"
        ),
        News(
            3,
            "Android 13: Google anuncia as funções esperadas da atualização",
            "O Android 13 teve seus primeiros detalhes revelados oficialmente nesta quinta-feira (10) pelo Google. O sistema operacional trará melhorias de privacidade, e algumas das funções anunciadas para o update também serão disponibilizadas para Androids mais antigos por meio das atualizações do Google Play.",
            "Beatriz Cardoso",
            "https://s2.glbimg.com/0YSMdkIamRT9l-xpwgWw1XaMxGw=/0x0:1023x682/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/3/A/1qktnBQbK2x5HxyxSEBA/android-11.jpg"
        ),
//        News(
//            "4",
//            "Redmi 10 começa a receber MIUI 13 Global baseada em Android 12",
//            "Acompanhando o cronograma anunciado pela Xiaomi em janeiro, o MIUI 13 Global começou a ser liberado para diversos aparelhos durante esse primeiro trimestre de 2022 e, agora, foi a vez do Redmi 10 receber a nova interface. Este é um dos primeiros modelos na faixa de entrada a receber o sistema",
//            "Tudo Celular",
//            "https://t2.tudocdn.net/589300?w=660&h=229"
//        ),
//        News(
//            "5",
//            "Android 13: Google lança a primeira prévia do sistema operacional para desenvolvedores",
//            "Nesta quinta-feira (10), o Google liberou a primeira prévia para desenvolvedores da próxima versão do seu sistema operacional, o Android 13, nomenclatura que também foi oficializada. A previsão da empresa é lançar o SO após agosto deste ano.\n" +
//                    "\n" +
//                    "De acordo com o Goole, apenas os desenvolvedores que possuem um dispositivo da linha Pixel (a partir da série 4) podem ter acesso neste momento. A empresa disse ainda que vai trabalhar com outras fabricantes para oferecer compilações em breve.",
//            "Tudo Celular",
//            "https://t2.tudocdn.net/610745?w=660"
//        ),
//        News(
//            "6",
//            "Android 13: Google anuncia as funções esperadas da atualização",
//            "O Android 13 teve seus primeiros detalhes revelados oficialmente nesta quinta-feira (10) pelo Google. O sistema operacional trará melhorias de privacidade, e algumas das funções anunciadas para o update também serão disponibilizadas para Androids mais antigos por meio das atualizações do Google Play.",
//            "Beatriz Cardoso",
//            "https://s2.glbimg.com/0YSMdkIamRT9l-xpwgWw1XaMxGw=/0x0:1023x682/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/3/A/1qktnBQbK2x5HxyxSEBA/android-11.jpg"
//        ),
//        News(
//            "7",
//            "Redmi 10 começa a receber MIUI 13 Global baseada em Android 12",
//            "Acompanhando o cronograma anunciado pela Xiaomi em janeiro, o MIUI 13 Global começou a ser liberado para diversos aparelhos durante esse primeiro trimestre de 2022 e, agora, foi a vez do Redmi 10 receber a nova interface. Este é um dos primeiros modelos na faixa de entrada a receber o sistema",
//            "Tudo Celular",
//            "https://t2.tudocdn.net/589300?w=660&h=229"
//        ),
//        News(
//            "8",
//            "Android 13: Google lança a primeira prévia do sistema operacional para desenvolvedores",
//            "Nesta quinta-feira (10), o Google liberou a primeira prévia para desenvolvedores da próxima versão do seu sistema operacional, o Android 13, nomenclatura que também foi oficializada. A previsão da empresa é lançar o SO após agosto deste ano.\n" +
//                    "\n" +
//                    "De acordo com o Goole, apenas os desenvolvedores que possuem um dispositivo da linha Pixel (a partir da série 4) podem ter acesso neste momento. A empresa disse ainda que vai trabalhar com outras fabricantes para oferecer compilações em breve.",
//            "Tudo Celular",
//            "https://t2.tudocdn.net/610745?w=660"
//        ),
//        News(
//            "9",
//            "Android 13: Google anuncia as funções esperadas da atualização",
//            "O Android 13 teve seus primeiros detalhes revelados oficialmente nesta quinta-feira (10) pelo Google. O sistema operacional trará melhorias de privacidade, e algumas das funções anunciadas para o update também serão disponibilizadas para Androids mais antigos por meio das atualizações do Google Play.",
//            "Beatriz Cardoso",
//            "https://s2.glbimg.com/0YSMdkIamRT9l-xpwgWw1XaMxGw=/0x0:1023x682/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/3/A/1qktnBQbK2x5HxyxSEBA/android-11.jpg"
//        ),
//        News(
//            "10",
//            "Redmi 10 começa a receber MIUI 13 Global baseada em Android 12",
//            "Acompanhando o cronograma anunciado pela Xiaomi em janeiro, o MIUI 13 Global começou a ser liberado para diversos aparelhos durante esse primeiro trimestre de 2022 e, agora, foi a vez do Redmi 10 receber a nova interface. Este é um dos primeiros modelos na faixa de entrada a receber o sistema",
//            "Tudo Celular",
//            "https://t2.tudocdn.net/589300?w=660&h=229"
//        ),
//        News(
//            "11",
//            "Android 13: Google lança a primeira prévia do sistema operacional para desenvolvedores",
//            "Nesta quinta-feira (10), o Google liberou a primeira prévia para desenvolvedores da próxima versão do seu sistema operacional, o Android 13, nomenclatura que também foi oficializada. A previsão da empresa é lançar o SO após agosto deste ano.\n" +
//                    "\n" +
//                    "De acordo com o Goole, apenas os desenvolvedores que possuem um dispositivo da linha Pixel (a partir da série 4) podem ter acesso neste momento. A empresa disse ainda que vai trabalhar com outras fabricantes para oferecer compilações em breve.",
//            "Tudo Celular",
//            "https://t2.tudocdn.net/610745?w=660"
//        )
    )
}
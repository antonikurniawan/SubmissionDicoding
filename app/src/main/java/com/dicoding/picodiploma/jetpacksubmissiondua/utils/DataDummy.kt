package com.dicoding.picodiploma.jetpacksubmissiondua.utils

import com.dicoding.picodiploma.jetpacksubmissiondua.detail.DetailFilmActivity
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response.TvResponse

object DataDummy {

    fun generateDummyMovie(): ArrayList<Film>{
        val movies = ArrayList<Film>()

        movies.add(Film(
            "https://i.pinimg.com/474x/9d/7f/2e/9d7f2e8d7316c77f7223da3f45b7a78c.jpg",
            "Wengi: Anak Mayit",
            "Semua berawal dari rumah warisan peninggalan orang tua Dewi (Sara Wijayanto). Dewi lalu memboyong anak semata wayangnya Bella (Atiya Shahab) meninggalkan Alex (Demian) suaminya. Tak disangka rumah peninggalan itu dipenuhi oleh misteri-misteri yang secara total merubah kehidupan Dewi dan Bella.Horor, teror, jeritan dan tangisan mengisi kehidupan mereka mulai saat itu. Sampai kapankah Dewi dan Bella bisa bertahan tinggal dirumah itu atau akankah ada solusi perdamaian dengan dunia ghoib itu?",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(
            Film(
                "https://m.media-amazon.com/images/M/MV5BMmU0NWVmMGYtNGE4Yi00NmNlLWE3OWQtZDlkODk0ZWM4MzJmXkEyXkFqcGdeQXVyNzY4NDQzNTg@._V1_.jpg",
                "Ikut Aku ke Neraka",
                "Hidup begitu sempurna bagi LITA (27thn), menikah dengan RAMA (30thn) Lelaki yang karirnya bagus sebagai management operasional di sebuah pabrik. Kehidupan mereka nyaris sempurna, ketika Lita akan melahirkan bayi pertama mereka. Saat hamil tua, Rama selalu ingin melihat Lita terlihat sempurna mendapat rekomendasi dari dokter ahli bedah plastik ternama, untuk bisa menghilangkan tanda lahir Lita di punggung nya, agar Lita lebih percaya diri. Proses operasi pun berjalan lancar, stretch mark di punggung Lita hilang.",
                DetailFilmActivity.FILM_TYPE_MOVIE
            ))

        movies.add(Film(
            "https://i.pinimg.com/736x/1c/5e/0a/1c5e0a88fa21420b74a8b18e06682b93.jpg",
            "Perjanjian Dengan Iblis",
            "ANNISA (24thn) menikah dengan BARA (32thn), duda dengan seorang anak perempuan bernama LARA (8thn). Bara ingin agar kedua orang yang dicintainya bisa akrab,maka ia mengajak keduanya piknik ke pulau yang masih jarang didatangi oleh para wisatawan, Pulau Bengalor.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://cdns.klimg.com/kapanlagi.com/p/posterfilmhorrorwewe.jpg",
            "Wewe",
            "Aruna, seorang bocah 5 tahun yang secara tiba-tiba hilang. Keluarganya mulai melakukan pencarian dan tidak sengaja membawa mereka semua pada sebuah rahasia menakutkan yang selama ini bersarang di sudut rumah baru mereka.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://i.pinimg.com/originals/22/e0/85/22e0853842c82c748b622ba5c569f9d4.jpg",
            "DreadOut",
            "Akibat rasa iri dan berharap mendapatkan popularitas lebih melalui media sosial, sekelompok pelajar SMA pergi ke apartemen angker untuk merekam kegiatan mereka. Secara tidak sengaja, mereka membuka portal misterius dan membangunkan iblis yang menyeret mereka masuk ke dalam neraka.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://upload.wikimedia.org/wikipedia/id/e/e1/Pengabdi_Setan_poster.jpg",
            "Pengabdi Setan",
            "Setelah sakit aneh selama 3 tahun, Ibu akhirnya meninggal dunia. Bapak lalu memutuskan untuk kerja di luar kota meninggalkan anak-anak. Tak lama kemudian, anak-anak merasa bahwa Ibu kembali berada di rumah. Situasi semakin menyeramkan ketika mereka mengetahui bahwa Ibu datang lagi tidak sekedar untuk menjenguk, tapi untuk menjemput mereka.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://i.pinimg.com/474x/87/22/8e/87228e0843c8f54d129a828e746a7207.jpg",
            "Rumah Dara",
            "Berkisah mengenai sekelompok pemuda-pemudi yang terjebak di rumah milik seorang pembunuh misterius yang bernama Dara.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://upload.wikimedia.org/wikipedia/id/thumb/6/68/Poster_film_Ratu_Ilmu_Hitam_2019.jpg/220px-Poster_film_Ratu_Ilmu_Hitam_2019.jpg",
            "Ratu Ilmu Hitam",
            "Hanif membawa Nadya istrinya dan ketiga anak mereka ke panti asuhan tempat Hanif dulu dibesarkan. Pengasuh panti itu, Pak Bandi, sudah sangat tua dan sakit keras, Hanif datang untuk menjenguk setelah bertahun-tahun tidak bertemu. Bukan cuma Hanif yang datang berkunjung, tapi juga dua sahabat Hanif saat tinggal di panti, Anton dan Jefri yang membawa istri-istri mereka. Malam itu mereka semua tiba di panti asuhan yang terletak di luar kota dan jauh dari pemukiman penduduk itu. Mereka bermaksud bermalam di sana untuk memberikan penghormatan terakhir buat orang yang telah mengasuh mereka sejak kecil. Mereka menyangka malam itu akan jadi malam yang penuh kedamaian. Mereka segera memahami bahwa mereka salah.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://cdn.idntimes.com/content-images/post/20200131/img-20200130-wa0000-4f8071645d92e20209b417674a7dfe86-436457d78616cb4f3c92fecc20576d81.jpg",
            "Suzzanna Santet",
            "Karena istrinya sakit-sakitan, Bisman (Jagat Karana) melirik Katemi (Suzanna). Untuk mendapat Katemi, Bisman membunuh istrinya dan menghasut penduduk bahwa yang membunuh istrinya adalah Sarma (Novie Chandra), suami Katemi. Penduduk terhasut dan Sarma dibunuh.",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        movies.add(Film(
            "https://m.media-amazon.com/images/M/MV5BM2EzNzhjNzgtNjc5MC00MWZmLWE3MTMtZjc2YTk0ZWIxYTJjXkEyXkFqcGdeQXVyNTg2MDI2Njc@._V1_UY1200_CR165,0,630,1200_AL_.jpg",
            "Sabrina",
            "MAIRA hidup bahagia di pernikahan barunya bersama AIDEN, pembuat boneka Sabrina sekaligus pemilik sebuah perusahaan mainan. Tapi kebahagiaan mereka belum sempurna karena VANYA, anak angkat sekaligus keponakan Aiden yang yang piatu belum bisa menerima kehadiran Maira sebagai ibunya karena Vanya masih belum bisa merelakan kepergian ANDINI, bundanya yang sudah meninggal. Suatu hari, Vanya melakukan permainan ‘Pensil Charlie’ untuk memanggil bundanya dan kejanggalan-kejanggalan pun mulai terjadi. Maira dan Aiden Adak percaya, hingga akhirnya Maira mengalami serentetan kejadian menakutkan dan mereka melihat sendiri sosok Andini. Maira pun memanggil BU LARAS, seorang paranormal yang dulu pernah membantunya. Tapi Andini ternyata bukanlah Andini, melainkan iblis keji bernama BAGHIAH yang menetap di boneka Sabrina dan menginginkan tubuh manusia...",
            DetailFilmActivity.FILM_TYPE_MOVIE
        ))

        return movies
    }

    fun generateDummyTvSeries(): ArrayList<Film>{
        val tvSeries = ArrayList<Film>()

        tvSeries.add(Film(
            "https://i.pinimg.com/736x/1f/ea/62/1fea62ef8ce4a468633b2219f1db2be9.jpg",
            "Ghoul",
            "Di masa depan India yang totaliter, seorang tahanan misterius dikirim ke pusat interogasi militer terpencil di mana dia membalikkan keadaan para penculiknya dengan mengungkap rahasia paling memalukan mereka dan melepaskan setan dari cerita rakyat Arab.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://www.orcasound.com/wp-content/uploads/2021/01/MV5BM2ExMmZlZDQtOTJiZC00Y2UzLWIxNDYtZTdiYzAzYzQyMmQ4XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
            "Lovecraft Country",
            "Serial ini bercerita tentang seorang pemuda kulit hitam yang melakukan perjalanan melintasi Amerika Serikat tahun 1950-an yang terpisah untuk mencari ayahnya yang hilang, mempelajari rahasia gelap yang mengganggu sebuah kota di mana penulis horor terkenal H. P. Lovecraft diduga mendasarkan lokasi dari banyak kisah fiksinya.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://i.pinimg.com/originals/2d/53/7a/2d537aee7bfb1030bde7b479d60fab41.jpg",
            "Stranger Things",
            "Setelah menghilangnya seorang anak laki-laki secara misterius dan tiba-tiba, orang-orang di kota kecil mulai mengungkap rahasia laboratorium pemerintah, portal ke dunia lain, dan monster-monster jahat. Ibu anak laki-laki itu (Joyce) dengan putus asa berusaha untuk menemukannya, yakin bahwa dia dalam bahaya besar, sementara kepala polisi mencari jawaban. Mencoba membantu menemukannya, teman-teman bocah itu menemukan seorang gadis kecil yang aneh, yang sedang dalam pelarian dari orang jahat.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://www.themoviedb.org/t/p/original/zPSnO5EG5THjRBzbCmZZ6V7QeVx.jpg",
            "V Wars",
            "V Wars mengikuti kisah dokter / ilmuwan Dr. Luther Swann, dan sahabatnya Michael Fayne, saat mereka menghadapi krisis yang berkembang dari wabah mematikan yang memecah masyarakat menjadi faksi-faksi yang berlawanan, berpotensi meningkat ke perang masa depan antara manusia dan vampir.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://resizing.flixster.com/E57ajWLD-4tLVp7Kj7g6j_FTKoE=/180x240/v1.dDs0NjIwNzM7ajsxODYwMzsyMDQ4OzE1MDA7MjAwMA",
            "Chambers",
            "Chambers mengikuti kisah seorang remaja yang, setelah menerima transplantasi jantung, dihantui oleh penglihatan yang tidak dapat dijelaskan. Ketika penglihatan semakin merepotkan dan terjadi lebih sering, dia mulai mengungkap keadaan dan konspirasi mengerikan yang menyebabkan kematian misterius pendonor.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://i.pinimg.com/originals/1b/b8/8e/1bb88e48c27d35976e976b5696b79269.jpg",
            "Dark",
            "Bercerita tentang buntut hilangnya seorang anak yang menyingkap rahasia dan hubungan tersembunyi antara empat keluarga yang tidak kenal satu sama lain dan mereka perlahan mengungkap persekongkolan perjalanan waktu lintas tiga generasi.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://m.media-amazon.com/images/M/MV5BODQ4NGIwZWYtMWNhOC00MzFjLTk5ZDYtOGM1MzM3NjVlZGUxXkEyXkFqcGdeQXVyNDg4MjkzNDk@._V1_UY1200_CR89,0,630,1200_AL_.jpg",
            "Marianne",
            "Serial horor asal Prancis ini mengisahkan teror mengerikan yang muncul di sebuah kota kecil bernama Elden. Emma Larsimon (Victoire Du Bois) adalah seorang penulis seri novel horor \"Lizzie Larck\", yang berhasil mendulang kesuksesan besar di Prancis.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://m.media-amazon.com/images/M/MV5BMTU4NzA4MDEwNF5BMl5BanBnXkFtZTgwMTQxODYzNjM@._V1_.jpg",
            "Haunting of Hill House",
            "Olivia (Clara Gugino) adalah seorang arsitek yang mempunyai bakat supranatural. Ia merenovasi sebuah rumah tua yang dibelinya bersama suami Hugh (Henry Thomas). Bersama kelima anak-anaknya, keduanya tinggal di rumah tua yang konon pernah ditinggali oleh keluarga Hill. Latar musim panas yang mengakibatkan tragedi dan membawa duka yang mendalam bagi kelima anak Crain itu tak pernah bisa dilupakan. Bahkan 20 tahun setelah mereka angkat kaki dari rumah tua Hill, teror masih mencekam. Steven, anak pertama kini menjadi penulis novel horor terlaris yang terinspirasi dari rumah Hill. Shirley yang tak pernah percaya hantu, ia menggunakan profesinya untuk mendirikan rumah duka Harris bersama suaminya. Theodora yang tomboi menjadi seorang psikolog sekaligus terapis untuk membantu anak-anak.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://m.media-amazon.com/images/M/MV5BMTYzYWU4NDUtNjI3OC00ZDAzLThhNzktNjkwMmE5NWZmOWRhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg",
            "Ju-On Origins",
            "Mengisahkan tentang sebuah rumah terkutuk. Dahulu kala, seorang gadis dikurung di rumah tersebut dan diperkosa hingga ia hamil. Tak lama kemudian, terjadi sebuah pembunuhan terhadap gadis tersebut dan bayinya. Anehnya, mayat gadis berhasil ditemukan namun tidak dengan si bayi.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        tvSeries.add(Film(
            "https://mir-s3-cdn-cf.behance.net/project_modules/disp/fbd4b017470227.562ba513afc1e.jpg",
            "American Horror Story Asylum",
            "Briarcliff dipimpin oleh Monsignor Timothy Howard (Joseph Fiennes) dan dikelola oleh Suster Jude (Jessica Lange). Institusi tersebut pada awalnya didirikan untuk menangani pasien sakit jiwa supaya mereka sembuh dan menjalani hidupnya sesuai dengan jalan yang diperintahkan Tuhan. Tapi pada kenyataannya, pasien-pasien disana tidaklah mendapat perawatan yang layak.",
            DetailFilmActivity.FILM_TYPE_TV_SERIES
        ))

        return tvSeries
    }

    fun generateRemoteDummyMovie(): ArrayList<MovieResponse>{
        val movieResponseList = ArrayList<MovieResponse>()

        movieResponseList.add(MovieResponse("m1",
                "Wengi: Anak Mayit",
                "Semua berawal dari rumah warisan peninggalan orang tua Dewi (Sara Wijayanto). Dewi lalu memboyong anak semata wayangnya Bella (Atiya Shahab) meninggalkan Alex (Demian) suaminya. Tak disangka rumah peninggalan itu dipenuhi oleh misteri-misteri yang secara total merubah kehidupan Dewi dan Bella.Horor, teror, jeritan dan tangisan mengisi kehidupan mereka mulai saat itu. Sampai kapankah Dewi dan Bella bisa bertahan tinggal dirumah itu atau akankah ada solusi perdamaian dengan dunia ghoib itu?",
                "https://i.pinimg.com/474x/9d/7f/2e/9d7f2e8d7316c77f7223da3f45b7a78c.jpg"))
        movieResponseList.add(MovieResponse("m2",
                "Ikut Aku ke Neraka",
                "Hidup begitu sempurna bagi LITA (27thn), menikah dengan RAMA (30thn) Lelaki yang karirnya bagus sebagai management operasional di sebuah pabrik. Kehidupan mereka nyaris sempurna, ketika Lita akan melahirkan bayi pertama mereka. Saat hamil tua, Rama selalu ingin melihat Lita terlihat sempurna mendapat rekomendasi dari dokter ahli bedah plastik ternama, untuk bisa menghilangkan tanda lahir Lita di punggung nya, agar Lita lebih percaya diri. Proses operasi pun berjalan lancar, stretch mark di punggung Lita hilang.",
                "https://m.media-amazon.com/images/M/MV5BMmU0NWVmMGYtNGE4Yi00NmNlLWE3OWQtZDlkODk0ZWM4MzJmXkEyXkFqcGdeQXVyNzY4NDQzNTg@._V1_.jpg"))
        movieResponseList.add(MovieResponse("m3",
                "Perjanjian Dengan Iblis",
                "ANNISA (24thn) menikah dengan BARA (32thn), duda dengan seorang anak perempuan bernama LARA (8thn). Bara ingin agar kedua orang yang dicintainya bisa akrab,maka ia mengajak keduanya piknik ke pulau yang masih jarang didatangi oleh para wisatawan, Pulau Bengalor.",
                "https://i.pinimg.com/736x/1c/5e/0a/1c5e0a88fa21420b74a8b18e06682b93.jpg"))
        movieResponseList.add(MovieResponse("m4",
                "Wewe",
                "Aruna, seorang bocah 5 tahun yang secara tiba-tiba hilang. Keluarganya mulai melakukan pencarian dan tidak sengaja membawa mereka semua pada sebuah rahasia menakutkan yang selama ini bersarang di sudut rumah baru mereka.",
                "https://cdns.klimg.com/kapanlagi.com/p/posterfilmhorrorwewe.jpg"))
        movieResponseList.add(MovieResponse("m5",
                "DreadOut",
                "Akibat rasa iri dan berharap mendapatkan popularitas lebih melalui media sosial, sekelompok pelajar SMA pergi ke apartemen angker untuk merekam kegiatan mereka. Secara tidak sengaja, mereka membuka portal misterius dan membangunkan iblis yang menyeret mereka masuk ke dalam neraka.",
                "https://i.pinimg.com/originals/22/e0/85/22e0853842c82c748b622ba5c569f9d4.jpg"))
        movieResponseList.add(MovieResponse("m6",
                "Pengabdi Setan",
                "Setelah sakit aneh selama 3 tahun, Ibu akhirnya meninggal dunia. Bapak lalu memutuskan untuk kerja di luar kota meninggalkan anak-anak. Tak lama kemudian, anak-anak merasa bahwa Ibu kembali berada di rumah. Situasi semakin menyeramkan ketika mereka mengetahui bahwa Ibu datang lagi tidak sekedar untuk menjenguk, tapi untuk menjemput mereka.",
                "https://upload.wikimedia.org/wikipedia/id/e/e1/Pengabdi_Setan_poster.jpg"))
        movieResponseList.add(MovieResponse("m7",
                "Rumah Dara",
                "Berkisah mengenai sekelompok pemuda-pemudi yang terjebak di rumah milik seorang pembunuh misterius yang bernama \"Dara\".",
                "https://i.pinimg.com/474x/87/22/8e/87228e0843c8f54d129a828e746a7207.jpg"))
        movieResponseList.add(MovieResponse("m8",
                "Ratu Ilmu Hitam",
                "Hanif membawa Nadya istrinya dan ketiga anak mereka ke panti asuhan tempat Hanif dulu dibesarkan. Pengasuh panti itu, Pak Bandi, sudah sangat tua dan sakit keras, Hanif datang untuk menjenguk setelah bertahun-tahun tidak bertemu. Bukan cuma Hanif yang datang berkunjung, tapi juga dua sahabat Hanif saat tinggal di panti, Anton dan Jefri yang membawa istri-istri mereka. Malam itu mereka semua tiba di panti asuhan yang terletak di luar kota dan jauh dari pemukiman penduduk itu. Mereka bermaksud bermalam di sana untuk memberikan penghormatan terakhir buat orang yang telah mengasuh mereka sejak kecil. Mereka menyangka malam itu akan jadi malam yang penuh kedamaian. Mereka segera memahami bahwa mereka salah.",
                "https://upload.wikimedia.org/wikipedia/id/thumb/6/68/Poster_film_Ratu_Ilmu_Hitam_2019.jpg/220px-Poster_film_Ratu_Ilmu_Hitam_2019.jpg"))
        movieResponseList.add(MovieResponse("m9",
                "Suzzanna Santet",
                "Karena istrinya sakit-sakitan, Bisman (Jagat Karana) melirik Katemi (Suzanna). Untuk mendapat Katemi, Bisman membunuh istrinya dan menghasut penduduk bahwa yang membunuh istrinya adalah Sarma (Novie Chandra), suami Katemi. Penduduk terhasut dan Sarma dibunuh.",
                "https://cdn.idntimes.com/content-images/post/20200131/img-20200130-wa0000-4f8071645d92e20209b417674a7dfe86-436457d78616cb4f3c92fecc20576d81.jpg"))
        movieResponseList.add(MovieResponse("m10",
                "Sabrina",
                "MAIRA hidup bahagia di pernikahan barunya bersama AIDEN, pembuat boneka Sabrina sekaligus pemilik sebuah perusahaan mainan. Tapi kebahagiaan mereka belum sempurna karena VANYA, anak angkat sekaligus keponakan Aiden yang yang piatu belum bisa menerima kehadiran Maira sebagai ibunya karena Vanya masih belum bisa merelakan kepergian ANDINI, bundanya yang sudah meninggal. Suatu hari, Vanya melakukan permainan ‘Pensil Charlie’ untuk memanggil bundanya dan kejanggalan-kejanggalan pun mulai terjadi. Maira dan Aiden Adak percaya, hingga akhirnya Maira mengalami serentetan kejadian menakutkan dan mereka melihat sendiri sosok Andini. Maira pun memanggil BU LARAS, seorang paranormal yang dulu pernah membantunya. Tapi Andini ternyata bukanlah Andini, melainkan iblis keji bernama BAGHIAH yang menetap di boneka Sabrina dan menginginkan tubuh manusia...",
                "https://m.media-amazon.com/images/M/MV5BM2EzNzhjNzgtNjc5MC00MWZmLWE3MTMtZjc2YTk0ZWIxYTJjXkEyXkFqcGdeQXVyNTg2MDI2Njc@._V1_UY1200_CR165,0,630,1200_AL_.jpg"))

        return movieResponseList

    }

    fun generateRemoteDummyTvSeries(): ArrayList<TvResponse>{
        val tvSeriesResponseList = ArrayList<TvResponse>()

        tvSeriesResponseList.add(TvResponse("t1",
                "Ghoul",
                "Di masa depan India yang totaliter, seorang tahanan misterius dikirim ke pusat interogasi militer terpencil di mana dia membalikkan keadaan para penculiknya dengan mengungkap rahasia paling memalukan mereka dan melepaskan setan dari cerita rakyat Arab.",
                "https://i.pinimg.com/736x/1f/ea/62/1fea62ef8ce4a468633b2219f1db2be9.jpg"))
        tvSeriesResponseList.add(TvResponse("t2",
                "Lovecraft Country",
                "Serial ini bercerita tentang seorang pemuda kulit hitam yang melakukan perjalanan melintasi Amerika Serikat tahun 1950-an yang terpisah untuk mencari ayahnya yang hilang, mempelajari rahasia gelap yang mengganggu sebuah kota di mana penulis horor terkenal H. P. Lovecraft diduga mendasarkan lokasi dari banyak kisah fiksinya.",
                "https://www.orcasound.com/wp-content/uploads/2021/01/MV5BM2ExMmZlZDQtOTJiZC00Y2UzLWIxNDYtZTdiYzAzYzQyMmQ4XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg"))
        tvSeriesResponseList.add(TvResponse("t3",
                "Stranger Things",
                "Setelah menghilangnya seorang anak laki-laki secara misterius dan tiba-tiba, orang-orang di kota kecil mulai mengungkap rahasia laboratorium pemerintah, portal ke dunia lain, dan monster-monster jahat. Ibu anak laki-laki itu (Joyce) dengan putus asa berusaha untuk menemukannya, yakin bahwa dia dalam bahaya besar, sementara kepala polisi mencari jawaban. Mencoba membantu menemukannya, teman-teman bocah itu menemukan seorang gadis kecil yang aneh, yang sedang dalam pelarian dari \"orang jahat\".",
                "https://i.pinimg.com/originals/2d/53/7a/2d537aee7bfb1030bde7b479d60fab41.jpg"))
        tvSeriesResponseList.add(TvResponse("t4",
                "V Wars",
                "V Wars mengikuti kisah dokter / ilmuwan Dr. Luther Swann, dan sahabatnya Michael Fayne, saat mereka menghadapi krisis yang berkembang dari wabah mematikan yang memecah masyarakat menjadi faksi-faksi yang berlawanan, berpotensi meningkat ke perang masa depan antara manusia dan vampir.",
                "https://www.themoviedb.org/t/p/original/zPSnO5EG5THjRBzbCmZZ6V7QeVx.jpg"))
        tvSeriesResponseList.add(TvResponse("t5",
                "Chambers",
                "Chambers mengikuti kisah seorang remaja yang, setelah menerima transplantasi jantung, dihantui oleh penglihatan yang tidak dapat dijelaskan. Ketika penglihatan semakin merepotkan dan terjadi lebih sering, dia mulai mengungkap keadaan dan konspirasi mengerikan yang menyebabkan kematian misterius pendonor.",
                "https://resizing.flixster.com/E57ajWLD-4tLVp7Kj7g6j_FTKoE=/180x240/v1.dDs0NjIwNzM7ajsxODYwMzsyMDQ4OzE1MDA7MjAwMA"))
        tvSeriesResponseList.add(TvResponse("t6",
                "Dark",
                "Bercerita tentang buntut hilangnya seorang anak yang menyingkap rahasia dan hubungan tersembunyi antara empat keluarga yang tidak kenal satu sama lain dan mereka perlahan mengungkap persekongkolan perjalanan waktu lintas tiga generasi.",
                "https://i.pinimg.com/originals/1b/b8/8e/1bb88e48c27d35976e976b5696b79269.jpg"))
        tvSeriesResponseList.add(TvResponse("t7",
                "Marianne",
                "Serial horor asal Prancis ini mengisahkan teror mengerikan yang muncul di sebuah kota kecil bernama Elden. Emma Larsimon (Victoire Du Bois) adalah seorang penulis seri novel horor \"Lizzie Larck\", yang berhasil mendulang kesuksesan besar di Prancis.",
                "https://m.media-amazon.com/images/M/MV5BODQ4NGIwZWYtMWNhOC00MzFjLTk5ZDYtOGM1MzM3NjVlZGUxXkEyXkFqcGdeQXVyNDg4MjkzNDk@._V1_UY1200_CR89,0,630,1200_AL_.jpg"))
        tvSeriesResponseList.add(TvResponse("t8",
                "Haunting of Hill House",
                "Olivia (Clara Gugino) adalah seorang arsitek yang mempunyai bakat supranatural. Ia merenovasi sebuah rumah tua yang dibelinya bersama suami Hugh (Henry Thomas). Bersama kelima anak-anaknya, keduanya tinggal di rumah tua yang konon pernah ditinggali oleh keluarga Hill. Latar musim panas yang mengakibatkan tragedi dan membawa duka yang mendalam bagi kelima anak Crain itu tak pernah bisa dilupakan. Bahkan 20 tahun setelah mereka angkat kaki dari rumah tua Hill, teror masih mencekam. Steven, anak pertama kini menjadi penulis novel horor terlaris yang terinspirasi dari rumah Hill. Shirley yang tak pernah percaya hantu, ia menggunakan profesinya untuk mendirikan rumah duka Harris bersama suaminya. Theodora yang tomboi menjadi seorang psikolog sekaligus terapis untuk membantu anak-anak.",
                "https://m.media-amazon.com/images/M/MV5BMTU4NzA4MDEwNF5BMl5BanBnXkFtZTgwMTQxODYzNjM@._V1_.jpg"))
        tvSeriesResponseList.add(TvResponse("t9",
                "Ju-On Origins",
                "Mengisahkan tentang sebuah rumah terkutuk. Dahulu kala, seorang gadis dikurung di rumah tersebut dan diperkosa hingga ia hamil. Tak lama kemudian, terjadi sebuah pembunuhan terhadap gadis tersebut dan bayinya. Anehnya, mayat gadis berhasil ditemukan namun tidak dengan si bayi.",
                "https://m.media-amazon.com/images/M/MV5BMTYzYWU4NDUtNjI3OC00ZDAzLThhNzktNjkwMmE5NWZmOWRhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg"))
        tvSeriesResponseList.add(TvResponse("t10",
                "American Horror Story Asylum",
                "Briarcliff dipimpin oleh Monsignor Timothy Howard (Joseph Fiennes) dan dikelola oleh Suster Jude (Jessica Lange). Institusi tersebut pada awalnya didirikan untuk menangani pasien sakit jiwa supaya mereka sembuh dan menjalani hidupnya sesuai dengan jalan yang diperintahkan Tuhan. Tapi pada kenyataannya, pasien-pasien disana tidaklah mendapat perawatan yang layak.",
                "https://mir-s3-cdn-cf.behance.net/project_modules/disp/fbd4b017470227.562ba513afc1e.jpg"))

        return tvSeriesResponseList
    }
//    fun generateRemoteDummyCourses(): java.util.ArrayList<CourseResponse> {
//
//        val courses = java.util.ArrayList<CourseResponse>()
//
//        courses.add(CourseResponse("a14",
//                "Menjadi Android Developer Expert",
//                "Dicoding sebagai satu-satunya Google Authorized Training Partner di Indonesia telah melalui proses penyusunan kurikulum secara komprehensif. Semua modul telah diverifikasi langsung oleh Google untuk memastikan bahwa materi yang diajarkan relevan dan sesuai dengan kebutuhan industri digital saat ini. Peserta akan belajar membangun aplikasi Android dengan materi Testing, Debugging, Application, Application UX, Fundamental Application Components, Persistent Data Storage, dan Enhanced System Integration.",
//                "100 Hari",
//                "https://www.dicoding.com/images/small/academy/menjadi_android_developer_expert_logo_070119140352.jpg"))
//        courses.add(CourseResponse("a55",
//                "Kotlin Android Developer Expert",
//                "Pada Google I/O 2017, Kotlin diumumkan sebagai bahasa pemrograman yang termasuk dalam bahasa kelas satu (First class) yang didukung untuk pembuatan aplikasi Android, selain Java dan C++. Kotlin adalah bahasa pemrograman yang dibuat oleh JetBrains. Google juga akan memastikan bahwa semua fitur baru di Android, framework, IDE dan keseluruhan library, akan dapat bekerja dan terintegrasi baik dengan bahasa pemrograman Kotlin serta interopable dengan fungsi-fungsi Java yang telah ada sehingga memungkinkan para engineer melakukan perubahan bagian tertentu aplikasi dari Java ke Kotlin dan sebaliknya dengan sangat mudah.",
//                "50 Hari",
//                "https://www.dicoding.com/images/small/academy/kotlin_android_developer_expert_logo_070119140227.jpg"))
//        courses.add(CourseResponse("a47",
//                "Menjadi Game Developer Expert",
//                "Semua modul dalam kelas ini telah diverifikasi langsung oleh Asosiasi Game Indonesia (AGI) untuk memastikan materi yang diajarkan relevan dan sesuai dengan kebutuhan industri game saat ini. Peserta akan belajar best practice membuat game seperti Script, Sprite, UI, Gameplay, Input Method, Porting ke Android / iOS, Modul Services (Collaboration, Ads, Analytics dan Google Play Games - Update Oktober 2018), Porting ke VR - Cardboard dan Gear VR (New Mei 2018) dengan Unity 3D. Peserta juga akan belajar langsung membuat 8 game yaitu Casual (Update Agustus 2018), Pilah Sampah (New November 2018), Tower Defense (New November 2018), Arcade (Update Maret 2018), Platformer (Update Januari 2019), FPS, Multiplayer (Update Maret 2018), serta Game Interaktif dengan VR (New Mei 2018).",
//                "75 Hari",
//                "https://www.dicoding.com/images/small/academy/menjadi_game_developer_expert_logo_070119140532.jpg"))
//        courses.add(CourseResponse("a74",
//                "Membangun Progressive Web Apps",
//                "Progressive Web Apps adalah aplikasi web yang memanfaatkan beragam fitur web modern sehingga dapat menyajikan pengalaman pengguna seperti aplikasi native. PWA mengubah sajian tampilan yang umumnya dibuka melalui halaman browser menjadi jendela aplikasi tersendiri. Selain itu PWA juga memungkinkan konten halaman diakses dalam mode offline, menampilkan pesan pemberitahuan, hingga akses ke hardware dari perangkat seperti halnya native app.",
//                "50 Hari",
//                "https://www.dicoding.com/images/small/academy/membangun_progressive_web_apps_logo_070119142922.jpg"))
//        courses.add(CourseResponse("a51",
//                "Belajar Membuat Aplikasi Android untuk Pemula", "Kelas ini didesain oleh Google Authorized Training Partner untuk developer Android di Indonesia. Peserta akan mempelajari materi dasar Android dalam 30 hari dan diarahkan untuk membuat aplikasi sederhana. Terdapat 27 modul yang juga merupakan bagian dari Kelas Menjadi Android Developer Expert. Peserta disarankan setidaknya memiliki pengetahuan tentang programming Java dan atau pemrograman berorientasi objek. Sistem pembelajaran adalah online (dapat diakses kapanpun dan darimanapun selama tersedia internet) dan kehadiran tatap muka tidak diperlukan. Tools yang diwajibkan untuk kelas belajar Android ini adalah Android Studio. Peserta harus submit satu proyek akhir yang akan direview oleh developer expert untuk mendapatkan sertifikat dari kelas ini. Bila menginginkan materi yang lebih komprehensif, silahkan mengikuti kelas Menjadi Android Developer Expert.",
//                "30 Hari",
//                "https://www.dicoding.com/images/small/academy/belajar_membuat_aplikasi_android_untuk_pemula_logo_070119140911.jpg"))
//
//        return courses
//    }
}
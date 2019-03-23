package book.bookReview;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movieArrayList;
    MovieAdapter adapter;

//    Создаем новый объект и вносим в него данные для приложения
    Movie[] movies = new Movie[] {
            new Movie("\"Я – легенда\"",
                    "Научно-фантастический роман американского писателя Ричарда Мэтисона, оказавший большое влияние на формирование в современной литературе образа вампиров, зомби, популяризации концепции всемирного апокалипсиса по причине пандемии и идеи описания вампиризма как заболевания. Роман, опубликованный в 1954 году, был достаточно успешен. По его мотивам сняты фильмы «Последний человек на Земле» (1964), «Человек Омега» (1971) и «Я — легенда» (2007). Кроме того, существует неофициальная экранизация — фильм «Я — воин» (2007). ",
                    "Ричард Мэтисон",
                    "https://www.oodon.com/wp-content/uploads/2017/07/I-am-Legend-Cover-1.jpg",
                    "dw-K-HYmy-Q",
                    1954,
                    160),
        new Movie("\"Дом, в котором...\"",
                "Роман Мариам Петросян, опубликованный в 2009 году. Представляет собой яркое и своеобразное описание замкнутого социума, его характерных особенностей, нюансов адаптации новичка в сложившемся коллективе на примере интерната для детей-инвалидов. Место и время действия намеренно абстрагированы, а в сюжете значимую роль играют фантастические мотивы. ",
                "Мариам Петросян",
                "https://upload.wikimedia.org/wikipedia/ru/c/c5/Dom%2C_v_kotorom..._%282009_cover%29.jpg",
                "9vhw4HzWBwU",
                2009,
                50),
        new Movie("\"Мы с истекшим сроком годности\"",
                "Главная героиня этой книги – счастливая девочка по имени Джин. Казалось бы, что может разрушить ее планы, ведь у нее все так хорошо складывается в жизни. Джин только исполнилось 17, но она уже заканчивает школу с отличием и собирается поступать в один из лучших университетов страны. Во всех ее затеях и планах, девушку поддерживают любящие родственники, милая младшая сестра и конечно же любимый парень-красавчик. Но на выпускном вечере происходит трагическое происшествие, которое ставит под угрозу все мечты Джин. После ужасной аварии девушке приходится передвигаться на инвалидной коляске. Потерявшая веру в лучшее будущее Джин попадает в центр реабилитации, где она будет заново всему учиться. Кто знает возможно именно эта трагедия позволит девушке найти себя, настоящих друзей и конечно же встретить любовь всей жизни.",
                "Стейс Крамер",
                "https://bibliosfera.su/image/cache/catalog/img/zarubezh/ND00025913-800x1000.png",
                "fqKHkvJdSfY",
                2016,
                278),
        new Movie("\"Над пропастью во ржи\"",
                "В середине 20 века Джером Дейвид Сэлинджер написал роман «Над пропастью во ржи», который прославил его на весь мир. Это произведение считается одним из самых значимых в литературе второй половины 20 века. Роман получил хорошую оценку как у молодых читателей, так и у более зрелых. Даже сейчас для многих подростков имя главного героя и название произведения является символом бунтарства и несогласия с современными общественными нормами морали.",
                "Джером Дейвид Сэлинджер",
                "https://rusbuk.ru/uploads/books/298352/c24677be85252190598cfaf032f94f57342a2efamax.jpeg",
                "adX_mPVdRMg",
                2007,
                26),
        new Movie("\"1984\"",
                "Главный герой — Уинстон Смит — живёт в Лондоне, работает в Министерстве правды и является членом внешней партии. Он не разделяет партийные лозунги и идеологию и в глубине души сильно сомневается в партии, окружающей действительности и вообще во всём том, в чём только можно сомневаться. Чтобы «выпустить пар» и не совершить какой-нибудь безрассудный поступок, ведёт дневник, в котором старается излагать все свои сомнения. На людях же притворяется приверженцем партийных идей. Однако опасается, что девушка Джулия, работающая в том же министерстве, шпионит за ним и хочет разоблачить его. В то же время полагает, что высокопоставленный сотрудник их министерства, член внутренней партии некий О’Брайен также не разделяет мнения партии и является подпольным революционером. ",
                "Джордж Оруэлл",
                "https://pl.spb.ru/upload/iblock/be7/be7481cc4e6a7f41e202752839dead3b.jpg",
                "cM6AWz1RYRM",
                1949,
                53),
        new Movie("\"Ведьмак\"",
                "Первый рассказ. Небольшое произведение, написанное для конкурса, стало началом «Саги о Ведьмаке и Ведьмачке». Профессиональный истребитель чудовищ — ведьмак Геральт прибывает в Вызиму, столицу Темерии, где завелась упырица, стрыга. Это дочь короля Фольтеста и его родной сестры Адды. Король жаждет расколдовать свою дочь, обещая хорошую награду. Геральт берётся за эту работу. Для победы ему нужно лишить упырицу возможности заночевать в саркофаге. Он побеждает упырицу и сам забирается в саркофаг, проводит там ночь и наутро видит расколдованную девочку. Однако при проверке упырица успевает полоснуть его когтями по шее. Геральт успевает остановить кровотечение, девочка остаётся в нормальном состоянии.",
                "Анджей Сапковский",
                "https://rusbuk.ru/uploads/books/325877/6186289ae7d90d6102b3554a57d821c9ca1aa4cemax.jpeg",
                "1UaQf8t5aps",
                1996,
                323),
    };

    //Связываем данные
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setIcon(R.drawable.ic_action_logo);
            actionBar.setTitle("    " + actionBar.getTitle());
        }

        movieArrayList = new ArrayList<>(Arrays.asList(movies));
        adapter = new MovieAdapter(this, movieArrayList);

        ListView movieListView = (ListView) findViewById(R.id.movieListView);
        movieListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        SearchView searchView = searchItem.getActionView() as SearchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Поиск", newText);

                movieArrayList.clear();

                if (newText.equals("")) {
                    movieArrayList.addAll(Arrays.asList(movies));
                } else {
                    for (Movie movie : movies) {
                        if (movie.getName().toLowerCase().contains(newText.toLowerCase())) {
                            movieArrayList.add(movie);
                        }
                    }
                }

                adapter.notifyDataSetChanged();

                return false;
            }
        });
            return super.onCreateOptionsMenu(menu);
    }

}

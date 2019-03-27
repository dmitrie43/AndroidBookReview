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
            new Movie("Основы программирования на языке С. Учебное пособие",
                    "Пособие является начальным курсом программирования с примерами на языке С. Рассмотрены основы программирования, приемы и методы в стиле классического С. Пособие можно использовать как руководство по языку, приводятся многочисленные примеры, оттестированные на компьютере.\n" +
                            "Рекомендовано студентам, изучающим дисциплины \"Основы программирования\", \"Языки высокого уровня\", \"Информатика\".",
                    "Дорогов Виктор Георгиевич, Дорогова Екатерина Георгиевна",
                    "https://static.my-shop.ru/product/2/110/1093252.jpg",
                    "6NNmH-gYkfI",
                    2018),
        new Movie("Программирование на C для начинающих",
                "Чтобы писать мощные программы на C, необязательно быть экспертом! Эта книга максимально быстро поможет вам освоить язык C благодаря невероятно четкому и простому изложению материала. Вы изучите все основные темы, связанные с этим языком: как организовать программу, хранить и отображать данные, работать с переменными, операторами, вводом/выводом, указателями, массивами, функциями и многими другими вещами. Язык программирования C еще никогда не был таким простым!",
                "Перри Грег, Миллер Дин",
                "https://static.my-shop.ru/product/2/196/1952524.jpg",
                "6NNmH-gYkfI",
                2015),
        new Movie("100 примеров на СИ",
                "Данная книга предназначена для практического изучения языка программирования Си. Изложение материала ведется на основе примеров. Перед примерами дается небольшая теоретическая часть, а затем разбираются конкретные примеры. Такой подход позволит читателю уже с первых шагов писать работающие программы. Примеры в книге приведены по нарастающей сложности: от простых программ с использованием простых конструкций до небольшой компьютерной игры и клиент-серверного приложения. Книга будет полезна всем, кто хочет максимально быстро и эффективно начать программировать на языке Си, а также тем, кто хочет получить набор готовых решений для разных ситуаций. Книга не требует начальных знаний программирования, лучший выбор для начинающих.\n",
                "Кольцов Д.М.",
                "https://static.my-shop.ru/product/2/271/2705230.jpg",
                "6NNmH-gYkfI",
                2017),
        new Movie("C# 4.0. Полное руководство",
                "В этом полном руководстве по C# 4.0 - языку программирования, разработанному специально для среды .NET, - детально рассмотрены все основные средства языка: типы данных, операторы, управляющие операторы, классы, интерфейсы, методы, делегаты, индексаторы, события, указатели, обобщения, коллекции, основные библиотеки классов, средства многопоточного программирования и директивы препроцессора. Подробно описаны новые возможности C#, в том числе PLINQ, библиотека TPL, динамический тип данных, а также именованные и необязательные аргументы. Это справочное пособие снабжено массой полезных советов авторитетного автора и сотнями примеров программ с комментариями, благодаря которым они становятся понятными любому читателю независимо от уровня его подготовки.\n" +
                        "Книга рассчитана на широкий круг читателей, интересующихся программированием на C#.",
                "Герберт Шилдт",
                "https://ozon-st.cdn.ngenix.net/multimedia/1005672732.jpg",
                "RSyVXy3EX2g",
                2015),
        new Movie("Язык программирования C# 6.0 и платформа .NET 4.6",
                "От издателя\n" +
                        "Новое 7-е издание этой книги было полностью пересмотрено и переписано с учетом последних изменений спецификации языка C# и новых достижений платформы .NET Framework. Отдельные главы посвящены важным новым средствам, которые делают .NET Framework 4.6 самым передовым выпуском, в том числе: - Усовершенствованная модель программирования ADO.NET Entity Framework; \n" +
                        "- Многочисленные улучшения IDE-среды и архитектуры MVVM для разработки настольных приложений WPF;\n" +
                        "- Многочисленные обновления в ASP.NET Web API.\n" +
                        "Помимо этого предлагается исчерпывающее рассмотрение всех ключевых возможностей языка C#, как старых, так и новых, что позволило обрести популярность предыдущим изданиям этой книги. Читатели получат основательные знания приемов объектно-ориентированной обработки, атрибутов и рефлексии, обобщений и коллекций, а также обретут понимание многих сложных тем, которые не раскрываются в других источниках (таких как коды операций CIL и выпуск динамических сборок).\n" +
                        "Основная миссия книги заключается в том, чтобы служить исчерпывающим руководством по языку программирования C# и ключевым аспектам платформы .NET, а также предоставлять обзорные сведения о технологиях, построенных на основе C# и .NET (ADO.NET и Entity Framework, Windows Communication Foundation (WCF), Windows Presentation Foundation (WPF) и ASP.NET (Web Forms, MVC, Web API)).\n" +
                        "Благодаря приведенной в книге информации у читателей появится возможность применять полученные знания при решении специфичных задач программирования и готовность к дальнейшим исследованиям мира .NET.",
                "Эндрю Троелсен, Филипп Джепикс ",
                "https://ozon-st.cdn.ngenix.net/multimedia/1015354746.jpg",
                "RSyVXy3EX2g",
                2016),
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

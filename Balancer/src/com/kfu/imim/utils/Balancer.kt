package com.kfu.imim.utils


import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//Объект-балансироващик. Основная функция - вызывать функцию balance для каждой задачи.
//Отличие от оптимизатора в том, что он вызывается только на этапе создания задачи и работает на клиенте (но можно
//сделать и на серваке, в то время как оптимизатор работает на сервере и предлагает способы ускорить/улучшить
//выполнение задачи за счёт освободившихся людей



class Test() {
    private var persons: ArrayList<Person>;

    private var person1: Person = Person("Jack Black", 40);
    private var person2: Person = Person("Black Jack", 35);
    private var person3: Person = Person("White Jack", 30);
    private var person4: Person = Person("Jack White", 37);
    private var person5: Person = Person("Jack Jack", 50);
    private var person6: Person = Person("White White", 32);
    private var person7: Person = Person("Black Black", 42);
    private var person8: Person = Person("White Black", 41);
    private var person9: Person = Person("Black White", 39);


    init {

        person1.addTechnology("html", 5)
        person1.addTechnology("spring", 6)
        person1.addTechnology("java", 6)
        person1.addTechnology("javascript", 8)
        person1.addTechnology("css", 6)
        person1.addTechnology("docker", 5)
        person2.addTechnology("python", 8)
        person2.addTechnology("jango", 7)
        person2.addTechnology("html", 6)
        person2.addTechnology("css", 9)
        person2.addTechnology("javascript", 6)
        person3.addTechnology("docker", 8)
        person3.addTechnology("git", 4)
        person3.addTechnology("html", 5)
        person3.addTechnology("java", 6)
        person3.addTechnology("javascript", 6)
        person3.addTechnology("hibernate", 8)
        person4.addTechnology("C", 9)
        person4.addTechnology("C++", 7)
        person5.addTechnology("vuejs", 5)
        person5.addTechnology("javascript", 6)
        person5.addTechnology("html", 7)
        person5.addTechnology("css", 8)
        person6.addTechnology("java", 9)
        person6.addTechnology("git", 9)
        person6.addTechnology("javascript", 9)
        person6.addTechnology("html", 9)
        person6.addTechnology("css", 9)
        person7.addTechnology("python", 9)
        person7.addTechnology("jango", 7)
        person8.addTechnology("php", 9)
        person8.addTechnology("laravel", 7)
        person8.addTechnology("yii2", 6)
        person9.addTechnology("C++", 7)
        person9.addTechnology("C#", 8)


        this.persons = arrayListOf(person1, person2, person3, person4, person5,
                person6, person7, person8, person9);
    }

    var subTask: SubTask = SubTask("tttt");
    var taskInstanceCreateStructure = TaskInstanceCreateStructure("Site", arrayListOf("javascript"), Date(), 400, 400, 4);
    var taskInstance = TaskInstance(taskInstanceCreateStructure, 3, arrayOf(subTask));

    public fun go(): ArrayList<Person> {
        return Recommendations(taskInstance, persons).recommendationOfTime();
    }
}

public fun main(args: Array<String>) {
    var test: Test = Test();
    println(test.go());
}


class Recommendations(_taskInstance: TaskInstance, _listofperson: ArrayList<Person>) {
    var taskInstance: TaskInstance;
    var listofperson: ArrayList<Person>;
    var mapWordsAndLetters: Map<String, String> = mapOf();

    init {
        taskInstance = _taskInstance;
        listofperson = _listofperson;
        val map = mutableMapOf("A" to "a", "B" to "b", "W" to "w", "D" to "d", "G" to "g", "H" to "h", "Q" to "q",
                "E" to "e", "J" to "j", "Z" to "z", "I" to "i", "K" to "k", "L" to "l", "F" to "f",
                "M" to "m", "N" to "n", "O" to "o", "P" to "p", "R" to "r", "S" to "s", "T" to "t", "U" to "u", "Y" to "y", "X" to "x");
        mapWordsAndLetters = map;
    }

    //Ищет по тегам в поиске исполнителей (тут можно добавить больше тегов)
    public fun searchByWords(): ArrayList<Person> {
        var newlistofperson: ArrayList<Person> = arrayListOf();
        var taskInstanceCreateStructure = taskInstance.gettaskInstanceCreateStructure();
        var searchstring = taskInstanceCreateStructure.getDescription();
        var arraystringwords = searchstring.split(" ");
        for (arr in arraystringwords) {
            if (arr.equals("site") || arr.equals("website")
                    || arr.equals("website") || arr.equals("web")) {
                for (person in listofperson) {
                    if (person.getTechnologies().containsKey("jango") && person.getTechnologies().containsKey("python")
                            || person.getTechnologies().containsKey("javascript")
                            && person.getTechnologies().containsKey("css") && person.getTechnologies().containsKey("html")) {
                        newlistofperson.add(person);
                    }

                }
            } else if (arr.equals("desktopapp")
                    || arr.equals("desktop")) {
                for (person in listofperson) {
                    if (person.getTechnologies().containsKey("java") || person.getTechnologies().containsKey("C++")) {
                        newlistofperson.add(person);
                    }
                }
            } else if (arr.equals("mobileapp")
                    || arr.equals("mobile")) {
                for (person in listofperson) {
                    if (person.getTechnologies().containsKey("kotlin") || person.getTechnologies().containsKey("java")) {
                        newlistofperson.add(person);
                    }
                }
            } else {
                continue;
            }
        }
        return newlistofperson;
    }

    //переводчик строк в нижний регистр
    public fun lower(): String {
        var string = "";
        var taskInstanceCreateStructure = taskInstance.gettaskInstanceCreateStructure();
        var searchstring = taskInstanceCreateStructure.getDescription();
        var arrayletters = searchstring.split("");
        for (letter in arrayletters) {
            string += mapWordsAndLetters.getOrDefault(letter, letter);
        }
        return string;
    }


    public fun skillLevelAndSkillNameSorted(): ArrayList<Person> {
        val level = taskInstance.gettaskInstanceCreateStructure().getSkilllevel();
        val skill = taskInstance.gettaskInstanceCreateStructure().getTechnologies();
        var newlistofperson: ArrayList<Person> = arrayListOf();
        for (person in listofperson) {
            for (map in person.getTechnologies()) {
                for (sk in skill) {
                    if (map.value > level && map.key.equals(sk)) {
                        newlistofperson.add(person);
                    }
                }
            }
        }
        return newlistofperson;
    }

    public fun recommendationOfTime(): ArrayList<Person> {
        var hrdlvl = taskInstance.getHardLevel();
        var newlistofperson: ArrayList<Person> = arrayListOf();
        for (person in listofperson) {
            for (exersize in person.getCurrentTasks()) {
                exersize.hardLevelAndHoursConnection();
            }
            taskInstance.hardLevelAndHoursConnection(hrdlvl);
            if (person.getFreeHours() == 0 || person.getFreeHours() < 0) {
                continue;
            } else {
                newlistofperson.add(person);
            }
        }
        return newlistofperson;
    }

    public fun recommendationOfTechnologies(): ArrayList<Person> {
        var newlistofperson: ArrayList<Person> = arrayListOf();
        for (person in listofperson) {
            for (skill in person.getTechnologies().keys) {
                for (skl in taskInstance.gettaskInstanceCreateStructure().getTechnologies()) {
                    if (skill.equals(skl)) {
                        newlistofperson.add(person);
                    }
                }
            }
        }
        return newlistofperson;
    }
}
//..

object Balancer {
    fun balance(taskInstance: TaskInstance, listofperson: ArrayList<Person>): ArrayList<Person> {
        //Эта функция принимает задачу и возвращает оптимальные рекомендации по времени/исполнителям/ресурсам
        //Вызывается из окна отрисовки клиента. Само собой этих исполнителей ещё надо получить
        var arraylist: ArrayList<Person> = arrayListOf();
        arraylist = Recommendations(taskInstance,Recommendations(taskInstance,Recommendations(taskInstance,Recommendations(taskInstance, listofperson).searchByWords()).recommendationOfTime()).recommendationOfTechnologies()).skillLevelAndSkillNameSorted();
        return arraylist;
    }

    fun balance (taskInstanceCreateStructure: TaskInstanceCreateStructure) : Recommendations {

        return Recommendations()
    }
}
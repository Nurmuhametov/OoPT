package com.kfu.imim.utils


class Person(_fullname: String, _freehours: Int) {
    private val fullname: String; //ФИО исполнителя
    private var freehours: Int;// количество свободных часов в неделю
    private val currentTasks: ArrayList<TaskInstance> = arrayListOf();// список взятых задач
    private val technologies: HashMap<String, Int> = hashMapOf();//пары технология - скилллевел

    init {
        fullname = _fullname;
        freehours = _freehours;
    }

    constructor(_fullname: String, _freehours: Int, _technologies: Map<String, Int>) : this(_fullname, _freehours) {
        technologies.plus(_technologies);

    }

    public fun addTechnology(value: String, skilllevel: Int) {
        technologies.put(value, skilllevel);
    }


    fun addCurrentTask(task: TaskInstance) {
        currentTasks.add(task);
    }

    public fun removeCurrentTask(task: TaskInstance) {
        currentTasks.remove(task);
    }

    public fun setFreeHours(value: Int): Boolean {
        if (value <= 168) {
            freehours = value;
            return true;
        }
        return false;
    }

    public fun getFreeHours(): Int {
        return freehours;
    }

    public fun getTechnologies(): HashMap<String, Int> {
        val new_technologies: HashMap<String, Int> = hashMapOf();
        new_technologies.putAll(technologies);
        return new_technologies;
    }

    public fun getCurrentTasks(): ArrayList<TaskInstance> {
        val new_currenttasks = arrayListOf<TaskInstance>();
        new_currenttasks.addAll(currentTasks);
        return new_currenttasks;
    }
}
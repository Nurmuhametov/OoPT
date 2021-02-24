package com.kfu.imim.utils

import java.util.concurrent.Executor


//Класс заданий. Тут будут создаваться все задания, их прогресс, текущие исполнители и прочая ерунда на ваш выбор
class TaskInstance(_taskInstanceCreateStructure: TaskInstanceCreateStructure, _hardlevel: Int, _subtasks: Array<SubTask>) {
    private val taskInstanceCreateStructure: TaskInstanceCreateStructure; //  само задание
    private val executors: ArrayList<Person> = arrayListOf();// список исполнителей
    private var progress: Int = 0;// прогресс
    private val subtasks: Array<SubTask>; // массив подзадач(нужно для прогресса)
    private val hardlevel: Int;

    init {
        taskInstanceCreateStructure = _taskInstanceCreateStructure.clone();
        subtasks = _subtasks.copyOf();
        hardlevel = _hardlevel;
    }


    public fun addExecutor(value: Person) {
        if (executors.size == 0) {
            taskInstanceCreateStructure.setStatus(Status.INWORK);
        }
        executors.add(value);
    }

    public fun completeSubTask(value: Int) {
        subtasks[value].completeTask();
        progress += 100 / subtasks.size;
        if (progress == 100) {
            taskInstanceCreateStructure.setStatus(Status.COMPLETE);
        }
    }

    public fun gettaskInstanceCreateStructure(): TaskInstanceCreateStructure {
        var newtaskInstanceCreateStructure = taskInstanceCreateStructure.clone();
        return newtaskInstanceCreateStructure;
    }

    public fun getHardLevel(): Int {
        return hardlevel;
    }

    public fun hardLevelAndHoursConnection() {
        for (person in executors) {
            when (hardlevel) {
                1 -> person.setFreeHours(person.getFreeHours() - 7);
                2 -> person.setFreeHours(person.getFreeHours() - 14);
                3 -> person.setFreeHours(person.getFreeHours() - 21);
                4 -> person.setFreeHours(person.getFreeHours() - 28);
                5 -> person.setFreeHours(person.getFreeHours() - 35);
                6 -> person.setFreeHours(person.getFreeHours() - 40);
                else -> {
                    person.setFreeHours(person.getFreeHours());
                }
            }
        }
    }

    public fun hardLevelAndHoursConnection(_hardlevel: Int) {
        for (person in executors) {
            when (_hardlevel) {
                1 -> person.setFreeHours(person.getFreeHours() - 7);
                2 -> person.setFreeHours(person.getFreeHours() - 14);
                3 -> person.setFreeHours(person.getFreeHours() - 21);
                4 -> person.setFreeHours(person.getFreeHours() - 28);
                5 -> person.setFreeHours(person.getFreeHours() - 35);
                6 -> person.setFreeHours(person.getFreeHours() - 40);
                else -> {
                    person.setFreeHours(person.getFreeHours());
                }
            }
        }
    }

}


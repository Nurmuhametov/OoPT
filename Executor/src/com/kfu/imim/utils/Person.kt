import com.kfu.imim.utils.TaskInstance

class Person(_fullname: String, _freehours: Int) {
    private val fullname: String; //ФИО исполнителя
    private val technologies: HashMap<String, Int> = hashMapOf();//список освоенных технологий
    private var freehours: Int;// количество свободных часов в неделю
    private val currentTasks: ArrayList<TaskInstance> = arrayListOf();// список взятых задач

    init {
        fullname = _fullname;
        freehours = _freehours;
    }

    constructor(_fullname: String, _freehours: Int, _technologies: HashMap<String,Int>) : this(_fullname, _freehours) {
        technologies.putAll(_technologies);
    }

    public fun addTechnology(value: String, skilllevel: Int) {
        technologies.put(value, skilllevel);
    }

    public fun addCurrentTask(task: TaskInstance) {
        currentTasks.add(task);
    }

    public fun removeCurrentTask(task: TaskInstance) {
        currentTasks.remove(task);
    }

    public fun setFreeHours(value: Int) {
        freehours = value;
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
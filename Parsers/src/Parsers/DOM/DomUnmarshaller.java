package Parsers.DOM;

import org.itroi.reminder.ReminderType;
import org.itroi.task.TaskType;
import org.itroi.tasks.TasksType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DomUnmarshaller  {


    private static final String BS_NS = "http://www.itroi.org/task";
    private static final String BS_NS_Task = "http://www.itroi.org/task";
    private static final String BS_NS_User = "http://www.itroi.org/user";
    private static final String BS_NS_Reminder = "http://www.itroi.org/reminder";
    private static final String BS_NS_Group = "http://www.itroi.org/group";

    public static void main(String[] arg) {
        DomUnmarshaller parser = new DomUnmarshaller();
        TasksType tasks = parser.unmarshal("src/dom.xml");
        System.out.println(tasks.toString());
    }


    public TasksType unmarshal(String filePath) {
        TasksType tasks= new TasksType();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            if (doc != null) {
                Element TasksElement = doc.getDocumentElement();
                if (TasksElement != null) {
                    NodeList taskNodeList = TasksElement.getChildNodes();
                    for (int i = 0; i < taskNodeList.getLength(); i++) {
                        if (taskNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            TaskType task = parseTask((Element) taskNodeList.item(i));
                            if (task != null) {
                                tasks.getTask().add(task);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private TaskType parseTask(Element taskElement) {
        TaskType task = new TaskType();
        task.setId(Integer.parseInt(taskElement.getAttribute("id")));
        task.setTitle(getValue(taskElement, "title"));
        task.setDate(getValue(taskElement, "date"));
        task.setTime(getValue(taskElement, "time"));
        task.setDuration(getValue(taskElement, "duration"));
        task.setDescription(getValue(taskElement, "description"));
        NodeList status = taskElement.getElementsByTagNameNS(BS_NS, "status");
        Element nodeStatus = (Element)status.item(0);
        task.getStatus().setId(Integer.parseInt(nodeStatus.getAttribute("id")));
        Node statusName = nodeStatus.getChildNodes().item(0);
        task.getStatus().setName(nodeStatus.getTextContent());
        NodeList user = taskElement.getElementsByTagNameNS(BS_NS, "user");
        Element nodeUser = (Element)user.item(0);
        task.getUser().setEmail(nodeUser.getAttribute("email"));
        Element reminders =(Element) taskElement.getElementsByTagNameNS(BS_NS, "reminders").item(0);
        NodeList reminderNodeList = reminders.getChildNodes();
        for (int i = 0; i < reminderNodeList.getLength(); i++) {
            if (reminderNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                ReminderType reminder = parseReminder((Element) reminderNodeList.item(i));
                if (reminder != null) {
                    task.getReminders().addReminder(reminder);
                }
            }
        }
        return task;
    }
private ReminderType parseReminder(Element element){
        ReminderType reminder = new ReminderType();
        reminder.setId(Integer.parseInt(element.getAttribute("id")));
        Element el =(Element) element.getElementsByTagNameNS(BS_NS_Reminder, "taskName").item(0);
reminder.setTaskName(el.getTextContent());
el= (Element) element.getElementsByTagNameNS(BS_NS_Reminder, "time").item(0);
reminder.setTime(el.getTextContent());
    el= (Element) element.getElementsByTagNameNS(BS_NS_Reminder, "taskId").item(0);
    reminder.setTaskId(Integer.parseInt(el.getTextContent()));
    return reminder;
    }
    private List<String> getValues(Element parent, String nodeName) {
        List<String> values = new ArrayList<>();
        NodeList elements = parent.getElementsByTagNameNS(BS_NS, nodeName);
        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node != null) {
                values.add(node.getTextContent());
            } else {
                values.add("");
            }
        }
        return values;
    }

    private String getValue(Element parent, String nodeName) {
        return getValues(parent, nodeName).get(0);
    }
}


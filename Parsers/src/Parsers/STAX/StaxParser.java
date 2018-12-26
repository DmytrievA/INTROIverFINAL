package Parsers.STAX;
import javafx.concurrent.Task;
import org.itroi.reminder.ReminderType;
import org.itroi.task.TaskType;
import org.itroi.tasks.TasksType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class StaxParser {


        // флаги для событий XML файла
        private static boolean titleFlag;
        private static boolean dateFlag;
        private static boolean timeFlag;
    private static boolean durationFlag;
    private static boolean descriptionFlag;
    private static boolean statusFlag;
    private static boolean nameFlag;
    private static boolean userFlag;
    private static boolean reminderFlag;
    private static boolean taskNameFlag;
    private static boolean timeReminderFlag;
    private static boolean taskIdFlag;

        public static void main(String[] args) {
            String fileName = "src/stax.xml";
            TasksType tasks = parseXMLfile(fileName);
            // печатаем в консоль информацию по каждому студенту
            System.out.println(tasks.toString());
        }

        // метод парсинга XML файла с помощью Cursor API
        private static TasksType parseXMLfile(String fileName) {
            TasksType tasks = new TasksType();
            TaskType task =new TaskType();
            ReminderType rem = new ReminderType();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            try {
                XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));
                // получаем первое событие
                int event = reader.getEventType();
                // обходим весь XML файл
                while (true) {
                    // проходим по типам событий
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT:
                            // в зависимости от имени тега отмечаем нужный фалг
                            if (reader.getLocalName().equals("ns5:task")) {

                                task.setId(Integer.parseInt(reader.getAttributeValue(0)));
                            } else if (reader.getLocalName().equals("title")) {
                                titleFlag = true;
                            } else if (reader.getLocalName().equals("date")) {
                                dateFlag = true;
                            } else if (reader.getLocalName().equals("time")) {
                                timeFlag = true;
                            }
                            else if (reader.getLocalName().equals("duration")) {
                                durationFlag = true;
                            }
                            else if (reader.getLocalName().equals("description")) {
                                descriptionFlag = true;
                            }
                            else if (reader.getLocalName().equals("status")) {
                                task.getStatus().setId(Integer.parseInt(reader.getAttributeValue(0)));
                            }
                            else if (reader.getLocalName().equals("name")) {
                                nameFlag = true;
                            }
                            else if (reader.getLocalName().equals("user")) {
                                task.getUser().setEmail(reader.getAttributeValue(0));
                            }
                            else if (reader.getLocalName().equals("reminder")) {

                                rem.setId(Integer.parseInt(reader.getAttributeValue(0)));

                            }
                            else if (reader.getLocalName().equals("taskName")) {
                                taskNameFlag = true;
                            }
                            else if (reader.getLocalName().equals("ns4:time")) {
                                timeReminderFlag = true;
                            }
                            else if (reader.getLocalName().equals("taskId")) {
                                taskIdFlag = true;
                            }
                            break;
                        // сохраняем данные XML-элемента,
                        // флаг которого равен true в объект Student
                        case XMLStreamConstants.CHARACTERS:
                            if (titleFlag) {
                                task.setTitle(reader.getText());
                                titleFlag = false;
                            } else  if (dateFlag) {
                                task.setDate(reader.getText());
                                dateFlag = false;
                            } else  if (timeFlag) {
                                task.setTime(reader.getText());
                                timeFlag = false;
                            }
                            else  if (durationFlag) {
                                task.setDuration(reader.getText());
                                durationFlag = false;
                            }
                            else  if (descriptionFlag) {
                                task.setDescription(reader.getText());
                                descriptionFlag = false;
                            }
                            else  if (nameFlag) {
                                task.getStatus().setName(reader.getText());
                                nameFlag = false;
                            }
                            else  if (taskNameFlag) {
                                rem.setTaskName(reader.getText());
                                taskNameFlag = false;
                            }
                            else  if (timeReminderFlag) {
                                rem.setTime(reader.getText());
                                timeReminderFlag = false;
                            }
                            else  if (taskIdFlag) {
                                rem.setTaskId(Integer.parseInt(reader.getText()));
                                taskIdFlag = false;
                            }
                            break;
                        // если цикл дошел до закрывающего элемента узла Student, то сохраняем объект в список
                        case XMLStreamConstants.END_ELEMENT:
                            if (reader.getLocalName().equals("task")) {
                                task.getReminders().addReminder(rem);
                                tasks.addTask(task);
                            }
                            break;
                    }
                    // если больше элементов нет, то заканчиваем обход файла
                    if (!reader.hasNext())
                        break;

                    // переход к следующему событию
                    event = reader.next();
                }

            } catch (FileNotFoundException | XMLStreamException e) {
                e.printStackTrace();
            }
            return tasks;
        }
    }


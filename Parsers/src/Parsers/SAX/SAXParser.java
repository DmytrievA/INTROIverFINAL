package Parsers.SAX;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.itroi.reminder.ReminderType;
import org.itroi.task.RemindersType;
import org.itroi.task.StatusType;
import org.itroi.task.TaskType;
import org.itroi.task.UserType;
import org.itroi.tasks.TasksType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler{
	private static boolean logEnabled = false;

	
	private static TasksType tasks;
	private UserType userValue;
	private StatusType status;
	private static TaskType task;
	private RemindersType reminders;
	private ReminderType reminder;
	private String timeParent;
	private String current;
	
	public static void log(Object o) {
		if (logEnabled) {
			System.out.println(o);
		}
	}
	@Override
	public void error(org.xml.sax.SAXParseException e) throws SAXException {
		throw e; // throw exception if xml not valid
	};
	
	public TasksType parse(InputStream in) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newInstance();

		factory.setNamespaceAware(true);
		// make parser validating
		//factory.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
		//factory.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

		javax.xml.parsers.SAXParser parser = factory.newSAXParser();
		parser.parse(in, this);

		return tasks;
	} 
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		current = localName;
		if(Const.TAG_TASKS.equals(current)) {
			tasks = new TasksType();
		}else if(Const.TAG_TASK.equals(current)){
			task = new TaskType();
			tasks.addTask(task);
			if (attributes.getLength() > 0)
				task.setId(Integer.parseInt(attributes.getValue("id")));
			timeParent = current;
		}else if(Const.TAG_REMINDER.equals(current)){
			reminder = new ReminderType();
			reminders.addReminder(reminder);
			if (attributes.getLength() > 0)
				reminder.setId(Integer.parseInt(attributes.getValue("id")));
			timeParent = current;
		}else if(Const.TAG_REMINDERS.equals(current)){
			reminders = new RemindersType();
			task.setReminders(reminders);
		}else if(Const.TAG_STATUS.equals(current)){
			status = new StatusType();
			if (attributes.getLength() > 0)
				status.setId(Integer.parseInt(attributes.getValue("id")));
		}else if(Const.TAG_USER.equals(current)){
			userValue = new UserType();
			task.setUser(userValue);
			if (attributes.getLength() > 0)
				userValue.setEmail(attributes.getValue("email"));
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(Const.TAG_TIME.equals(current)){
			if(Const.TAG_REMINDER.equals(timeParent))
				reminder.setTime(new String(ch,start,length));
			if(Const.TAG_TASK.equals(timeParent)){
				task.setTime(new String(ch,start,length));
			}
		}else if(Const.TAG_TASK_ID.equals(current)){
			reminder.setTaskId(Integer.parseInt(new String(ch, start, length)));
		}else if(Const.TAG_TASK_NAME.equals(current)){
			reminder.setTaskName(new String(ch,start,length));
		}else if(Const.TAG_TITLE.equals(current)){
			task.setTitle(new String(ch,start,length));
		}else if(Const.TAG_NAME.equals(current)){
			status.setName(new String(ch,start,length));
		}else if(Const.TAG_DATE.equals(current)){
			task.setDate(new String(ch,start,length));
		}else if(Const.TAG_DURATION.equals(current)){
			task.setDuration(new String(ch,start,length));
		}else if(Const.TAG_DESCRIPTION.equals(current)){
			task.setDescription(new String(ch,start,length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(current);
		if(Const.TAG_TASK.equals(current)){
			tasks.addTask(task);
		}else if(Const.TAG_REMINDER.equals(current)){
			reminders.addReminder(reminder);
		}else if(Const.TAG_REMINDERS.equals(current)){
			task.setReminders(reminders);
		}
	}


	
	public TasksType getTasks(){
		return tasks;
	}
	public static void main(String[] args)
			throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		System.out.println("--== SAX Parser ==--");
		SAXParser parser = new SAXParser();
		parser.parse(new FileInputStream("Parsers/src/sax.xml"));
		System.out.println("====================================");
		System.out.println("Here is the tasks: \n" + tasks.toString());
		System.out.println("====================================");
	}
}

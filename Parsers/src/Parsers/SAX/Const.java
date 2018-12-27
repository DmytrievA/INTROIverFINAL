package Parsers.SAX;

public interface Const {

	public static final String FEATURE__TURN_VALIDATION_ON = 
				"http://xml.org/sax/features/validation";
	public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON = 
			"http://apache.org/xml/features/validation/schema";
	
	String TAG_TASKS = "tasks";
	String TAG_TASK = "task";
	String TAG_STATUS = "status";
	String TAG_TITLE = "title";
	String TAG_DATE = "date";
	String TAG_TIME = "time";
	String TAG_DURATION = "duration";
	String TAG_DESCRIPTION = "description";
	String TAG_NAME = "name";
	String TAG_USER = "user";
	String TAG_REMINDERS = "reminders";
	String TAG_GIVEN_TASK = "givenTask";
	String TAG_USER_VALUE = "userValue";
	String TAG_REMINDER = "reminder";
	String TAG_GENDER = "gender";
	String TAG_PASSWORD = "password";
	String TAG_LOGIN = "login";
	String TAG_EMAIL = "email";
	String TAG_SURNAME = "surname";
	String TAG_MEMBER_OF_GROUPS = "memberOfGroups";
	String TAG_MEMBER_OF_GROUP = "memberOfGroup";
	String TAG_ROLE = "role";
	String TAG_GROUP = "group";
	String TAG_GROUP_ROLE = "groupRole";
	String TAG_GROUP_ROLE_NAME = "groupRoleName";
	String TAG_TASK_NAME = "taskName";
	String TAG_TASK_ID = "taskId";
	String TAG_LEVEL = "level";
	String TAG_TASK_DOC = "taskDoc";
	String TAG_COMMENTS = "comments";
	String TAG_MENTOR = "mentor";
	String TAG_FILE = "file";
	String TAG_RESULT = "result";
	String TAG_FINISH_FATE = "finishDate";
	
}

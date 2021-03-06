// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package eventapplication.proxies;

public class Homework
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject homeworkMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "EventApplication.Homework";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Date("Date"),
		Subjects("Subjects"),
		Homework("Homework"),
		Submission_Date("Submission_Date"),
		Homework_Staff("EventApplication.Homework_Staff");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Homework(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "EventApplication.Homework"));
	}

	protected Homework(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject homeworkMendixObject)
	{
		if (homeworkMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("EventApplication.Homework", homeworkMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a EventApplication.Homework");

		this.homeworkMendixObject = homeworkMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Homework.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static eventapplication.proxies.Homework initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return eventapplication.proxies.Homework.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static eventapplication.proxies.Homework initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new eventapplication.proxies.Homework(context, mendixObject);
	}

	public static eventapplication.proxies.Homework load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return eventapplication.proxies.Homework.initialize(context, mendixObject);
	}

	public static java.util.List<eventapplication.proxies.Homework> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<eventapplication.proxies.Homework> result = new java.util.ArrayList<eventapplication.proxies.Homework>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//EventApplication.Homework" + xpathConstraint))
			result.add(eventapplication.proxies.Homework.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Date
	 */
	public final java.util.Date getDate()
	{
		return getDate(getContext());
	}

	/**
	 * @param context
	 * @return value of Date
	 */
	public final java.util.Date getDate(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.Date.toString());
	}

	/**
	 * Set value of Date
	 * @param date
	 */
	public final void setDate(java.util.Date date)
	{
		setDate(getContext(), date);
	}

	/**
	 * Set value of Date
	 * @param context
	 * @param date
	 */
	public final void setDate(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date date)
	{
		getMendixObject().setValue(context, MemberNames.Date.toString(), date);
	}

	/**
	 * @return value of Subjects
	 */
	public final java.lang.String getSubjects()
	{
		return getSubjects(getContext());
	}

	/**
	 * @param context
	 * @return value of Subjects
	 */
	public final java.lang.String getSubjects(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Subjects.toString());
	}

	/**
	 * Set value of Subjects
	 * @param subjects
	 */
	public final void setSubjects(java.lang.String subjects)
	{
		setSubjects(getContext(), subjects);
	}

	/**
	 * Set value of Subjects
	 * @param context
	 * @param subjects
	 */
	public final void setSubjects(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String subjects)
	{
		getMendixObject().setValue(context, MemberNames.Subjects.toString(), subjects);
	}

	/**
	 * @return value of Homework
	 */
	public final java.lang.String getHomework()
	{
		return getHomework(getContext());
	}

	/**
	 * @param context
	 * @return value of Homework
	 */
	public final java.lang.String getHomework(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Homework.toString());
	}

	/**
	 * Set value of Homework
	 * @param homework
	 */
	public final void setHomework(java.lang.String homework)
	{
		setHomework(getContext(), homework);
	}

	/**
	 * Set value of Homework
	 * @param context
	 * @param homework
	 */
	public final void setHomework(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String homework)
	{
		getMendixObject().setValue(context, MemberNames.Homework.toString(), homework);
	}

	/**
	 * @return value of Submission_Date
	 */
	public final java.util.Date getSubmission_Date()
	{
		return getSubmission_Date(getContext());
	}

	/**
	 * @param context
	 * @return value of Submission_Date
	 */
	public final java.util.Date getSubmission_Date(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.Submission_Date.toString());
	}

	/**
	 * Set value of Submission_Date
	 * @param submission_date
	 */
	public final void setSubmission_Date(java.util.Date submission_date)
	{
		setSubmission_Date(getContext(), submission_date);
	}

	/**
	 * Set value of Submission_Date
	 * @param context
	 * @param submission_date
	 */
	public final void setSubmission_Date(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date submission_date)
	{
		getMendixObject().setValue(context, MemberNames.Submission_Date.toString(), submission_date);
	}

	/**
	 * @return value of Homework_Staff
	 */
	public final eventapplication.proxies.Staff getHomework_Staff() throws com.mendix.core.CoreException
	{
		return getHomework_Staff(getContext());
	}

	/**
	 * @param context
	 * @return value of Homework_Staff
	 */
	public final eventapplication.proxies.Staff getHomework_Staff(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		eventapplication.proxies.Staff result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Homework_Staff.toString());
		if (identifier != null)
			result = eventapplication.proxies.Staff.load(context, identifier);
		return result;
	}

	/**
	 * Set value of Homework_Staff
	 * @param homework_staff
	 */
	public final void setHomework_Staff(eventapplication.proxies.Staff homework_staff)
	{
		setHomework_Staff(getContext(), homework_staff);
	}

	/**
	 * Set value of Homework_Staff
	 * @param context
	 * @param homework_staff
	 */
	public final void setHomework_Staff(com.mendix.systemwideinterfaces.core.IContext context, eventapplication.proxies.Staff homework_staff)
	{
		if (homework_staff == null)
			getMendixObject().setValue(context, MemberNames.Homework_Staff.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.Homework_Staff.toString(), homework_staff.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return homeworkMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final eventapplication.proxies.Homework that = (eventapplication.proxies.Homework) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "EventApplication.Homework";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}

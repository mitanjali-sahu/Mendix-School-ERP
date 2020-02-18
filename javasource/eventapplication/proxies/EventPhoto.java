// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package eventapplication.proxies;

public class EventPhoto extends system.proxies.Image
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "EventApplication.EventPhoto";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		PublicThumbnailPath("PublicThumbnailPath"),
		FileID("FileID"),
		Name("Name"),
		DeleteAfterDownload("DeleteAfterDownload"),
		Contents("Contents"),
		HasContents("HasContents"),
		Size("Size"),
		EventDetails_EventPhoto("EventApplication.EventDetails_EventPhoto");

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

	public EventPhoto(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "EventApplication.EventPhoto"));
	}

	protected EventPhoto(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject eventPhotoMendixObject)
	{
		super(context, eventPhotoMendixObject);
		if (!com.mendix.core.Core.isSubClassOf("EventApplication.EventPhoto", eventPhotoMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a EventApplication.EventPhoto");
	}

	/**
	 * @deprecated Use 'EventPhoto.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static eventapplication.proxies.EventPhoto initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return eventapplication.proxies.EventPhoto.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static eventapplication.proxies.EventPhoto initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new eventapplication.proxies.EventPhoto(context, mendixObject);
	}

	public static eventapplication.proxies.EventPhoto load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return eventapplication.proxies.EventPhoto.initialize(context, mendixObject);
	}

	public static java.util.List<eventapplication.proxies.EventPhoto> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<eventapplication.proxies.EventPhoto> result = new java.util.ArrayList<eventapplication.proxies.EventPhoto>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//EventApplication.EventPhoto" + xpathConstraint))
			result.add(eventapplication.proxies.EventPhoto.initialize(context, obj));
		return result;
	}

	/**
	 * @return value of EventDetails_EventPhoto
	 */
	public final eventapplication.proxies.EventDetails getEventDetails_EventPhoto() throws com.mendix.core.CoreException
	{
		return getEventDetails_EventPhoto(getContext());
	}

	/**
	 * @param context
	 * @return value of EventDetails_EventPhoto
	 */
	public final eventapplication.proxies.EventDetails getEventDetails_EventPhoto(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		eventapplication.proxies.EventDetails result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.EventDetails_EventPhoto.toString());
		if (identifier != null)
			result = eventapplication.proxies.EventDetails.load(context, identifier);
		return result;
	}

	/**
	 * Set value of EventDetails_EventPhoto
	 * @param eventdetails_eventphoto
	 */
	public final void setEventDetails_EventPhoto(eventapplication.proxies.EventDetails eventdetails_eventphoto)
	{
		setEventDetails_EventPhoto(getContext(), eventdetails_eventphoto);
	}

	/**
	 * Set value of EventDetails_EventPhoto
	 * @param context
	 * @param eventdetails_eventphoto
	 */
	public final void setEventDetails_EventPhoto(com.mendix.systemwideinterfaces.core.IContext context, eventapplication.proxies.EventDetails eventdetails_eventphoto)
	{
		if (eventdetails_eventphoto == null)
			getMendixObject().setValue(context, MemberNames.EventDetails_EventPhoto.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.EventDetails_EventPhoto.toString(), eventdetails_eventphoto.getMendixObject().getId());
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final eventapplication.proxies.EventPhoto that = (eventapplication.proxies.EventPhoto) obj;
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
		return "EventApplication.EventPhoto";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Override
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}

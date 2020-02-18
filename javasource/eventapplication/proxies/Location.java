// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package eventapplication.proxies;

public class Location
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject locationMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "EventApplication.Location";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Street("Street"),
		HouseNumber("HouseNumber"),
		Postalcode("Postalcode"),
		City("City"),
		Longitude("Longitude"),
		Latitude("Latitude");

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

	public Location(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "EventApplication.Location"));
	}

	protected Location(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject locationMendixObject)
	{
		if (locationMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("EventApplication.Location", locationMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a EventApplication.Location");

		this.locationMendixObject = locationMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Location.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static eventapplication.proxies.Location initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return eventapplication.proxies.Location.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static eventapplication.proxies.Location initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new eventapplication.proxies.Location(context, mendixObject);
	}

	public static eventapplication.proxies.Location load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return eventapplication.proxies.Location.initialize(context, mendixObject);
	}

	public static java.util.List<eventapplication.proxies.Location> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<eventapplication.proxies.Location> result = new java.util.ArrayList<eventapplication.proxies.Location>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//EventApplication.Location" + xpathConstraint))
			result.add(eventapplication.proxies.Location.initialize(context, obj));
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
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of Street
	 */
	public final java.lang.String getStreet()
	{
		return getStreet(getContext());
	}

	/**
	 * @param context
	 * @return value of Street
	 */
	public final java.lang.String getStreet(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Street.toString());
	}

	/**
	 * Set value of Street
	 * @param street
	 */
	public final void setStreet(java.lang.String street)
	{
		setStreet(getContext(), street);
	}

	/**
	 * Set value of Street
	 * @param context
	 * @param street
	 */
	public final void setStreet(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String street)
	{
		getMendixObject().setValue(context, MemberNames.Street.toString(), street);
	}

	/**
	 * @return value of HouseNumber
	 */
	public final java.lang.String getHouseNumber()
	{
		return getHouseNumber(getContext());
	}

	/**
	 * @param context
	 * @return value of HouseNumber
	 */
	public final java.lang.String getHouseNumber(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.HouseNumber.toString());
	}

	/**
	 * Set value of HouseNumber
	 * @param housenumber
	 */
	public final void setHouseNumber(java.lang.String housenumber)
	{
		setHouseNumber(getContext(), housenumber);
	}

	/**
	 * Set value of HouseNumber
	 * @param context
	 * @param housenumber
	 */
	public final void setHouseNumber(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String housenumber)
	{
		getMendixObject().setValue(context, MemberNames.HouseNumber.toString(), housenumber);
	}

	/**
	 * @return value of Postalcode
	 */
	public final java.lang.String getPostalcode()
	{
		return getPostalcode(getContext());
	}

	/**
	 * @param context
	 * @return value of Postalcode
	 */
	public final java.lang.String getPostalcode(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Postalcode.toString());
	}

	/**
	 * Set value of Postalcode
	 * @param postalcode
	 */
	public final void setPostalcode(java.lang.String postalcode)
	{
		setPostalcode(getContext(), postalcode);
	}

	/**
	 * Set value of Postalcode
	 * @param context
	 * @param postalcode
	 */
	public final void setPostalcode(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String postalcode)
	{
		getMendixObject().setValue(context, MemberNames.Postalcode.toString(), postalcode);
	}

	/**
	 * @return value of City
	 */
	public final java.lang.String getCity()
	{
		return getCity(getContext());
	}

	/**
	 * @param context
	 * @return value of City
	 */
	public final java.lang.String getCity(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.City.toString());
	}

	/**
	 * Set value of City
	 * @param city
	 */
	public final void setCity(java.lang.String city)
	{
		setCity(getContext(), city);
	}

	/**
	 * Set value of City
	 * @param context
	 * @param city
	 */
	public final void setCity(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String city)
	{
		getMendixObject().setValue(context, MemberNames.City.toString(), city);
	}

	/**
	 * @return value of Longitude
	 */
	public final java.math.BigDecimal getLongitude()
	{
		return getLongitude(getContext());
	}

	/**
	 * @param context
	 * @return value of Longitude
	 */
	public final java.math.BigDecimal getLongitude(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Longitude.toString());
	}

	/**
	 * Set value of Longitude
	 * @param longitude
	 */
	public final void setLongitude(java.math.BigDecimal longitude)
	{
		setLongitude(getContext(), longitude);
	}

	/**
	 * Set value of Longitude
	 * @param context
	 * @param longitude
	 */
	public final void setLongitude(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal longitude)
	{
		getMendixObject().setValue(context, MemberNames.Longitude.toString(), longitude);
	}

	/**
	 * @return value of Latitude
	 */
	public final java.math.BigDecimal getLatitude()
	{
		return getLatitude(getContext());
	}

	/**
	 * @param context
	 * @return value of Latitude
	 */
	public final java.math.BigDecimal getLatitude(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Latitude.toString());
	}

	/**
	 * Set value of Latitude
	 * @param latitude
	 */
	public final void setLatitude(java.math.BigDecimal latitude)
	{
		setLatitude(getContext(), latitude);
	}

	/**
	 * Set value of Latitude
	 * @param context
	 * @param latitude
	 */
	public final void setLatitude(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal latitude)
	{
		getMendixObject().setValue(context, MemberNames.Latitude.toString(), latitude);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return locationMendixObject;
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
			final eventapplication.proxies.Location that = (eventapplication.proxies.Location) obj;
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
		return "EventApplication.Location";
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

// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package mendixsso.proxies;

public class DecryptedToken
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject decryptedTokenMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "MendixSSO.DecryptedToken";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		CreatedAt("CreatedAt"),
		ExpiresIn("ExpiresIn"),
		ExpiresAt("ExpiresAt"),
		TokenType("TokenType"),
		Value("Value"),
		SessionId("SessionId"),
		DecryptedToken_User("MendixSSO.DecryptedToken_User");

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

	public DecryptedToken(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "MendixSSO.DecryptedToken"));
	}

	protected DecryptedToken(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject decryptedTokenMendixObject)
	{
		if (decryptedTokenMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("MendixSSO.DecryptedToken", decryptedTokenMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a MendixSSO.DecryptedToken");

		this.decryptedTokenMendixObject = decryptedTokenMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'DecryptedToken.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static mendixsso.proxies.DecryptedToken initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return mendixsso.proxies.DecryptedToken.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static mendixsso.proxies.DecryptedToken initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new mendixsso.proxies.DecryptedToken(context, mendixObject);
	}

	public static mendixsso.proxies.DecryptedToken load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return mendixsso.proxies.DecryptedToken.initialize(context, mendixObject);
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
	 * @return value of CreatedAt
	 */
	public final java.util.Date getCreatedAt()
	{
		return getCreatedAt(getContext());
	}

	/**
	 * @param context
	 * @return value of CreatedAt
	 */
	public final java.util.Date getCreatedAt(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.CreatedAt.toString());
	}

	/**
	 * Set value of CreatedAt
	 * @param createdat
	 */
	public final void setCreatedAt(java.util.Date createdat)
	{
		setCreatedAt(getContext(), createdat);
	}

	/**
	 * Set value of CreatedAt
	 * @param context
	 * @param createdat
	 */
	public final void setCreatedAt(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date createdat)
	{
		getMendixObject().setValue(context, MemberNames.CreatedAt.toString(), createdat);
	}

	/**
	 * @return value of ExpiresIn
	 */
	public final java.lang.Integer getExpiresIn()
	{
		return getExpiresIn(getContext());
	}

	/**
	 * @param context
	 * @return value of ExpiresIn
	 */
	public final java.lang.Integer getExpiresIn(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.ExpiresIn.toString());
	}

	/**
	 * Set value of ExpiresIn
	 * @param expiresin
	 */
	public final void setExpiresIn(java.lang.Integer expiresin)
	{
		setExpiresIn(getContext(), expiresin);
	}

	/**
	 * Set value of ExpiresIn
	 * @param context
	 * @param expiresin
	 */
	public final void setExpiresIn(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer expiresin)
	{
		getMendixObject().setValue(context, MemberNames.ExpiresIn.toString(), expiresin);
	}

	/**
	 * @return value of ExpiresAt
	 */
	public final java.util.Date getExpiresAt()
	{
		return getExpiresAt(getContext());
	}

	/**
	 * @param context
	 * @return value of ExpiresAt
	 */
	public final java.util.Date getExpiresAt(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.ExpiresAt.toString());
	}

	/**
	 * Set value of ExpiresAt
	 * @param expiresat
	 */
	public final void setExpiresAt(java.util.Date expiresat)
	{
		setExpiresAt(getContext(), expiresat);
	}

	/**
	 * Set value of ExpiresAt
	 * @param context
	 * @param expiresat
	 */
	public final void setExpiresAt(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date expiresat)
	{
		getMendixObject().setValue(context, MemberNames.ExpiresAt.toString(), expiresat);
	}

	/**
	 * Set value of TokenType
	 * @param tokentype
	 */
	public final mendixsso.proxies.TokenType getTokenType()
	{
		return getTokenType(getContext());
	}

	/**
	 * @param context
	 * @return value of TokenType
	 */
	public final mendixsso.proxies.TokenType getTokenType(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.TokenType.toString());
		if (obj == null)
			return null;

		return mendixsso.proxies.TokenType.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of TokenType
	 * @param tokentype
	 */
	public final void setTokenType(mendixsso.proxies.TokenType tokentype)
	{
		setTokenType(getContext(), tokentype);
	}

	/**
	 * Set value of TokenType
	 * @param context
	 * @param tokentype
	 */
	public final void setTokenType(com.mendix.systemwideinterfaces.core.IContext context, mendixsso.proxies.TokenType tokentype)
	{
		if (tokentype != null)
			getMendixObject().setValue(context, MemberNames.TokenType.toString(), tokentype.toString());
		else
			getMendixObject().setValue(context, MemberNames.TokenType.toString(), null);
	}

	/**
	 * @return value of Value
	 */
	public final java.lang.String getValue()
	{
		return getValue(getContext());
	}

	/**
	 * @param context
	 * @return value of Value
	 */
	public final java.lang.String getValue(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Value.toString());
	}

	/**
	 * Set value of Value
	 * @param value
	 */
	public final void setValue(java.lang.String value)
	{
		setValue(getContext(), value);
	}

	/**
	 * Set value of Value
	 * @param context
	 * @param value
	 */
	public final void setValue(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String value)
	{
		getMendixObject().setValue(context, MemberNames.Value.toString(), value);
	}

	/**
	 * @return value of SessionId
	 */
	public final java.lang.String getSessionId()
	{
		return getSessionId(getContext());
	}

	/**
	 * @param context
	 * @return value of SessionId
	 */
	public final java.lang.String getSessionId(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.SessionId.toString());
	}

	/**
	 * Set value of SessionId
	 * @param sessionid
	 */
	public final void setSessionId(java.lang.String sessionid)
	{
		setSessionId(getContext(), sessionid);
	}

	/**
	 * Set value of SessionId
	 * @param context
	 * @param sessionid
	 */
	public final void setSessionId(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String sessionid)
	{
		getMendixObject().setValue(context, MemberNames.SessionId.toString(), sessionid);
	}

	/**
	 * @return value of DecryptedToken_User
	 */
	public final system.proxies.User getDecryptedToken_User() throws com.mendix.core.CoreException
	{
		return getDecryptedToken_User(getContext());
	}

	/**
	 * @param context
	 * @return value of DecryptedToken_User
	 */
	public final system.proxies.User getDecryptedToken_User(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		system.proxies.User result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.DecryptedToken_User.toString());
		if (identifier != null)
			result = system.proxies.User.load(context, identifier);
		return result;
	}

	/**
	 * Set value of DecryptedToken_User
	 * @param decryptedtoken_user
	 */
	public final void setDecryptedToken_User(system.proxies.User decryptedtoken_user)
	{
		setDecryptedToken_User(getContext(), decryptedtoken_user);
	}

	/**
	 * Set value of DecryptedToken_User
	 * @param context
	 * @param decryptedtoken_user
	 */
	public final void setDecryptedToken_User(com.mendix.systemwideinterfaces.core.IContext context, system.proxies.User decryptedtoken_user)
	{
		if (decryptedtoken_user == null)
			getMendixObject().setValue(context, MemberNames.DecryptedToken_User.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.DecryptedToken_User.toString(), decryptedtoken_user.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return decryptedTokenMendixObject;
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
			final mendixsso.proxies.DecryptedToken that = (mendixsso.proxies.DecryptedToken) obj;
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
		return "MendixSSO.DecryptedToken";
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

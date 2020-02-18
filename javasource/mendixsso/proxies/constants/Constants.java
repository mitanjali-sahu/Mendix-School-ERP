// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package mendixsso.proxies.constants;

import com.mendix.core.Core;

public class Constants
{
	// These are the constants for the MendixSSO module

	public static java.lang.Long getAuthRequestExpiryDurationInMinutes()
	{
		return (java.lang.Long)Core.getConfiguration().getConstantValue("MendixSSO.AuthRequestExpiryDurationInMinutes");
	}

	/**
	* When your application contains SSO user objects based on a previous user entity and no customized user data has to be retained, you can choose to enable automatic deletion of the old user object  and provisioning of the new user object when that user logs in. Setting the default value of this constant to true will enable this.
	* (Also read MendixSSO documentation, section "Incompatible user data type")
	* 
	* Note: keep in mind that all your defined delete behaviors will trigger as well.
	*/
	public static boolean getConsentToDeleteIncompatibleUsers()
	{
		return (java.lang.Boolean)Core.getConfiguration().getConstantValue("MendixSSO.ConsentToDeleteIncompatibleUsers");
	}

	public static java.lang.Long getDeleteTokenBatchSize()
	{
		return (java.lang.Long)Core.getConfiguration().getConstantValue("MendixSSO.DeleteTokenBatchSize");
	}

	/**
	* Prefix for stored encrypted values.
	* This value is used to determine whether the value has been already encrypted.
	*/
	public static java.lang.String getEncryptionPrefix()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.EncryptionPrefix");
	}

	/**
	* This is the password which is used to communicate with the Mendix SSO Provider. This password will be set automatically on deployment in the Mendix Cloud. 
	*/
	public static java.lang.String getEnvironmentPassword()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.EnvironmentPassword");
	}

	/**
	* This is the environment UUID which is used to communicate with the Mendix SSO Provider to identify this application. This UUID will be set automatically on deployment in the Mendix Cloud. 
	*/
	public static java.lang.String getEnvironmentUUID()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.EnvironmentUUID");
	}

	public static java.lang.Long getIdTokenValidatorMaxClockSkew()
	{
		return (java.lang.Long)Core.getConfiguration().getConstantValue("MendixSSO.IdTokenValidatorMaxClockSkew");
	}

	public static java.lang.String getIndexPage()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.IndexPage");
	}

	public static java.lang.String getLogNode()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.LogNode");
	}

	public static java.lang.String getMxID2_OpenIDPrefix()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.MxID2_OpenIDPrefix");
	}

	public static java.lang.String getOpenIdConnectDiscoveryPath()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.OpenIdConnectDiscoveryPath");
	}

	public static java.lang.String getOpenIdConnectProvider()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.OpenIdConnectProvider");
	}

	public static java.lang.String getOpenIdConnectScopes()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.OpenIdConnectScopes");
	}

	/**
	* This constant defines the location of the Permissions API provider in the Mendix Cloud. This constant value will be set by the Mendix Cloud upon deployment.
	*/
	public static java.lang.String getPermissionsAPI_Location()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.PermissionsAPI_Location");
	}

	/**
	* Indicates whether MendixSSO will be enabled on startup, allowing app users to login with their Mendix account. The default value of this constant is 'false' for local deployments, as MendixSSO is a cloud product.
	* The value will be automatically set to 'true' during deployment in the Mendix Cloud. 
	* 
	* When enabled, Single Sign On will be initiated by navigating to "<App URL>/openid/login" or clicking the 'Mendix Account' button on the login page.
	*/
	public static boolean getSSOEnabled()
	{
		return (java.lang.Boolean)Core.getConfiguration().getConstantValue("MendixSSO.SSOEnabled");
	}

	public static java.lang.String getSupportEmail()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.SupportEmail");
	}

	public static java.lang.String getSupportEmailSubject()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.SupportEmailSubject");
	}

	/**
	* This key will be used to encrypt and decrypt tokens.
	* The length of this key must be exactly 16 characters.
	* 
	* For local deployment change this value to some random 16 character string.
	*/
	public static java.lang.String getTokenEncryptionKey()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.TokenEncryptionKey");
	}

	/**
	* 30 days = 30 * 24 * 60*60 seonds
	* 
	* 2592000
	*/
	public static java.lang.Long getTokenExpiryInSeconds()
	{
		return (java.lang.Long)Core.getConfiguration().getConstantValue("MendixSSO.TokenExpiryInSeconds");
	}

	public static java.lang.String getTryAgainText()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.TryAgainText");
	}

	public static java.lang.String getVersion()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("MendixSSO.Version");
	}
}
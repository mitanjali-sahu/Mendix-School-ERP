package mendixsso.implementation.utils;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IDataType;

import java.util.Map;

class MicroflowParameter {

    private final String name;
    private final String type;
    private final boolean isMendixObject;
    private final boolean isInputParameter;
    private final boolean isSubClassOfSystemUser;

    MicroflowParameter(String name, String type, boolean isMendixObject, boolean isInputParameter, boolean isSubClassOfSystemUser) {
        this.name = name;
        this.type = type;
        this.isMendixObject = isMendixObject;
        this.isInputParameter = isInputParameter;
        this.isSubClassOfSystemUser = isSubClassOfSystemUser;
    }

    public void validate(String microflowName, Map<String, IDataType> inputParameters, IDataType returnType) {
        final IDataType dataType;

        if (this.isInputParameter) {
            if (!inputParameters.containsKey(this.name)) {
                throw new MendixRuntimeException(String.format("Missing input parameter in the '%s' microflow. " +
                        "Expected parameter: '%s'", microflowName, this.name));
            }
            dataType = inputParameters.get(this.name);
        } else {
            dataType = returnType;
        }

        if (this.isMendixObject) {
            if (dataType.isNothing() || !dataType.isMendixObject() || !dataType.toString().equals(this.type)) {
                final String errorMessage;
                if (this.isInputParameter) {
                    errorMessage = String.format("Invalid input parameter type for parameter '%s' in the '%s' microflow. " +
                            "Actual type: '%s', expected type: '%s'.", this.name, microflowName, dataType.toString(), this.type);
                } else {
                    errorMessage = String.format("Invalid return parameter type in the '%s' microflow. " +
                            "Actual type: '%s', expected type: '%s'.", microflowName, dataType.toString(), this.type);
                }
                throw new MendixRuntimeException(errorMessage);
            }

            if (this.isSubClassOfSystemUser) {
                final String objectType = dataType.getObjectType();
                if (objectType == null || !Core.isSubClassOf("System.User", objectType)) {
                    final String errorMessage;
                    if (this.isInputParameter) {
                        errorMessage = String.format("Invalid input parameter type for parameter '%s' in the '%s' microflow. " +
                                "Actual type: '%s', expected type: derived from '%s'.", this.name, microflowName, objectType, "System.User");
                    } else {
                        errorMessage = String.format("Invalid return parameter type in the '%s' microflow. " +
                                "Actual type: '%s', expected type: derived from '%s'.", microflowName, objectType, "System.User");
                    }
                    throw new MendixRuntimeException(errorMessage);
                }
            }
        } else {
            if (!dataType.toString().equals(this.type)) {
                throw new MendixRuntimeException(String.format("Invalid parameter type for parameter '%s' in the '%s' microflow. " +
                        "Actual type: '%s', expected type: '%s'.", this.name, microflowName, dataType.toString(), this.type));
            }
        }
    }

}

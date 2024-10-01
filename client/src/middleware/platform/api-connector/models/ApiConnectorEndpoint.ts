/* tslint:disable */
/* eslint-disable */
/**
 * The Platform API Connector Internal API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
import type { HttpMethod } from './HttpMethod';
import {
    HttpMethodFromJSON,
    HttpMethodFromJSONTyped,
    HttpMethodToJSON,
} from './HttpMethod';

/**
 * An API connector.
 * @export
 * @interface ApiConnectorEndpoint
 */
export interface ApiConnectorEndpoint {
    /**
     * The created by.
     * @type {string}
     * @memberof ApiConnectorEndpoint
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof ApiConnectorEndpoint
     */
    readonly createdDate?: Date;
    /**
     * The description of an API connector's endpoint.
     * @type {string}
     * @memberof ApiConnectorEndpoint
     */
    description?: string;
    /**
     * 
     * @type {HttpMethod}
     * @memberof ApiConnectorEndpoint
     */
    httpMethod?: HttpMethod;
    /**
     * The id of the API connector's endpoint.
     * @type {number}
     * @memberof ApiConnectorEndpoint
     */
    id?: number;
    /**
     * The last execution date.
     * @type {Date}
     * @memberof ApiConnectorEndpoint
     */
    readonly lastExecutionDate?: Date;
    /**
     * The last modified by.
     * @type {string}
     * @memberof ApiConnectorEndpoint
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof ApiConnectorEndpoint
     */
    readonly lastModifiedDate?: Date;
    /**
     * The name of an API connector's endpoint.
     * @type {string}
     * @memberof ApiConnectorEndpoint
     */
    name: string;
    /**
     * The path of an API connector's endpoint.
     * @type {string}
     * @memberof ApiConnectorEndpoint
     */
    path?: string;
    /**
     * 
     * @type {number}
     * @memberof ApiConnectorEndpoint
     */
    version?: number;
}



/**
 * Check if a given object implements the ApiConnectorEndpoint interface.
 */
export function instanceOfApiConnectorEndpoint(value: object): value is ApiConnectorEndpoint {
    if (!('name' in value) || value['name'] === undefined) return false;
    return true;
}

export function ApiConnectorEndpointFromJSON(json: any): ApiConnectorEndpoint {
    return ApiConnectorEndpointFromJSONTyped(json, false);
}

export function ApiConnectorEndpointFromJSONTyped(json: any, ignoreDiscriminator: boolean): ApiConnectorEndpoint {
    if (json == null) {
        return json;
    }
    return {
        
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'description': json['description'] == null ? undefined : json['description'],
        'httpMethod': json['httpMethod'] == null ? undefined : HttpMethodFromJSON(json['httpMethod']),
        'id': json['id'] == null ? undefined : json['id'],
        'lastExecutionDate': json['lastExecutionDate'] == null ? undefined : (new Date(json['lastExecutionDate'])),
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'name': json['name'],
        'path': json['path'] == null ? undefined : json['path'],
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function ApiConnectorEndpointToJSON(value?: Omit<ApiConnectorEndpoint, 'createdBy'|'createdDate'|'lastExecutionDate'|'lastModifiedBy'|'lastModifiedDate'> | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'description': value['description'],
        'httpMethod': HttpMethodToJSON(value['httpMethod']),
        'id': value['id'],
        'name': value['name'],
        'path': value['path'],
        '__version': value['version'],
    };
}

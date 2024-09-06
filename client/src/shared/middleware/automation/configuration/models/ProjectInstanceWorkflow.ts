/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Configuration Internal API
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
import type { ProjectInstanceWorkflowConnection } from './ProjectInstanceWorkflowConnection';
import {
    ProjectInstanceWorkflowConnectionFromJSON,
    ProjectInstanceWorkflowConnectionFromJSONTyped,
    ProjectInstanceWorkflowConnectionToJSON,
} from './ProjectInstanceWorkflowConnection';

/**
 * Contains configuration and connections required for the execution of a particular project workflow.
 * @export
 * @interface ProjectInstanceWorkflow
 */
export interface ProjectInstanceWorkflow {
    /**
     * The created by.
     * @type {string}
     * @memberof ProjectInstanceWorkflow
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof ProjectInstanceWorkflow
     */
    readonly createdDate?: Date;
    /**
     * The input parameters of an project instance used as workflow input values.
     * @type {{ [key: string]: any; }}
     * @memberof ProjectInstanceWorkflow
     */
    inputs?: { [key: string]: any; };
    /**
     * The connections used by a project instance.
     * @type {Array<ProjectInstanceWorkflowConnection>}
     * @memberof ProjectInstanceWorkflow
     */
    connections?: Array<ProjectInstanceWorkflowConnection>;
    /**
     * If a workflow is enabled or not in the project instance workflow.
     * @type {boolean}
     * @memberof ProjectInstanceWorkflow
     */
    enabled?: boolean;
    /**
     * The id of a project instance workflow.
     * @type {number}
     * @memberof ProjectInstanceWorkflow
     */
    readonly id?: number;
    /**
     * The last execution date of a project instance.
     * @type {Date}
     * @memberof ProjectInstanceWorkflow
     */
    lastExecutionDate?: Date;
    /**
     * The last modified by.
     * @type {string}
     * @memberof ProjectInstanceWorkflow
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof ProjectInstanceWorkflow
     */
    readonly lastModifiedDate?: Date;
    /**
     * The id of a project instance.
     * @type {number}
     * @memberof ProjectInstanceWorkflow
     */
    projectInstanceId?: number;
    /**
     * The url of a static url used to trigger a workflow.
     * @type {string}
     * @memberof ProjectInstanceWorkflow
     */
    staticWebhookUrl?: string;
    /**
     * The id of a workflow.
     * @type {string}
     * @memberof ProjectInstanceWorkflow
     */
    workflowId?: string;
    /**
     * The workflow reference code
     * @type {string}
     * @memberof ProjectInstanceWorkflow
     */
    readonly workflowReferenceCode?: string;
    /**
     * 
     * @type {number}
     * @memberof ProjectInstanceWorkflow
     */
    version?: number;
}

/**
 * Check if a given object implements the ProjectInstanceWorkflow interface.
 */
export function instanceOfProjectInstanceWorkflow(value: object): value is ProjectInstanceWorkflow {
    return true;
}

export function ProjectInstanceWorkflowFromJSON(json: any): ProjectInstanceWorkflow {
    return ProjectInstanceWorkflowFromJSONTyped(json, false);
}

export function ProjectInstanceWorkflowFromJSONTyped(json: any, ignoreDiscriminator: boolean): ProjectInstanceWorkflow {
    if (json == null) {
        return json;
    }
    return {
        
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'inputs': json['inputs'] == null ? undefined : json['inputs'],
        'connections': json['connections'] == null ? undefined : ((json['connections'] as Array<any>).map(ProjectInstanceWorkflowConnectionFromJSON)),
        'enabled': json['enabled'] == null ? undefined : json['enabled'],
        'id': json['id'] == null ? undefined : json['id'],
        'lastExecutionDate': json['lastExecutionDate'] == null ? undefined : (new Date(json['lastExecutionDate'])),
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'projectInstanceId': json['projectInstanceId'] == null ? undefined : json['projectInstanceId'],
        'staticWebhookUrl': json['staticWebhookUrl'] == null ? undefined : json['staticWebhookUrl'],
        'workflowId': json['workflowId'] == null ? undefined : json['workflowId'],
        'workflowReferenceCode': json['workflowReferenceCode'] == null ? undefined : json['workflowReferenceCode'],
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function ProjectInstanceWorkflowToJSON(value?: Omit<ProjectInstanceWorkflow, 'createdBy'|'createdDate'|'id'|'lastModifiedBy'|'lastModifiedDate'|'workflowReferenceCode'> | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'inputs': value['inputs'],
        'connections': value['connections'] == null ? undefined : ((value['connections'] as Array<any>).map(ProjectInstanceWorkflowConnectionToJSON)),
        'enabled': value['enabled'],
        'lastExecutionDate': value['lastExecutionDate'] == null ? undefined : ((value['lastExecutionDate']).toISOString()),
        'projectInstanceId': value['projectInstanceId'],
        'staticWebhookUrl': value['staticWebhookUrl'],
        'workflowId': value['workflowId'],
        '__version': value['version'],
    };
}

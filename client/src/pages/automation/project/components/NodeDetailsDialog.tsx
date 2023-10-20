import * as Dialog from '@radix-ui/react-dialog';
import {Cross1Icon, InfoCircledIcon} from '@radix-ui/react-icons';
import Button from 'components/Button/Button';
import Properties from 'components/Properties/Properties';
import {useGetActionDefinitionQuery} from 'queries/actionDefinitions.queries';
import {
    useGetComponentDefinitionQuery,
    useGetComponentDefinitionsQuery,
} from 'queries/componentDefinitions.queries';
import {useEffect, useState} from 'react';
import {twMerge} from 'tailwind-merge';

import Select from '../../../../components/Select/Select';
import Tooltip from '../../../../components/Tooltip/Tooltip';
import {useNodeDetailsDialogStore} from '../stores/useNodeDetailsDialogStore';
import CurrentActionSelect from './CurrentActionSelect';
import ConnectionTab from './node-details-tabs/ConnectionTab';
import DescriptionTab from './node-details-tabs/DescriptionTab';
import OutputTab from './node-details-tabs/OutputTab';

const tabs = [
    {
        label: 'Description',
        name: 'description',
    },
    {
        label: 'Connection',
        name: 'connection',
    },
    {
        label: 'Properties',
        name: 'properties',
    },
    {
        label: 'Output',
        name: 'output',
    },
];

const NodeDetailsDialog = () => {
    const [activeTab, setActiveTab] = useState('description');
    const [currentActionName, setCurrentActionName] = useState('');

    const {currentNode, nodeDetailsOpen, setNodeDetailsOpen} =
        useNodeDetailsDialogStore();

    const {data: componentDefinitions} = useGetComponentDefinitionsQuery({
        connectionDefinitions: true,
    });

    const {data: currentComponent} = useGetComponentDefinitionQuery({
        componentName: currentNode.originNodeName || currentNode.name,
    });

    const getActionName = (): string => {
        const currentComponentActionNames = currentComponent?.actions?.map(
            (action) => action.name
        );

        return currentComponentActionNames?.includes(currentActionName)
            ? currentActionName
            : (currentComponent?.actions?.[0]?.name as string);
    };

    const {data: currentAction, isFetched: currentActionFetched} =
        useGetActionDefinitionQuery(
            {
                actionName: getActionName(),
                componentName: currentComponent?.name as string,
                componentVersion: currentComponent?.version as number,
            },
            !!currentComponent?.actions
        );

    const componentDefinitionNames = componentDefinitions?.map(
        (component) => component.name
    );

    useEffect(() => {
        if (currentActionFetched) {
            if (!currentAction?.properties?.length) {
                setActiveTab('description');
            }

            if (activeTab === 'output' && !currentAction) {
                setActiveTab('description');
            }
        }

        if (
            activeTab === 'connection' &&
            currentComponent?.name &&
            !componentDefinitionNames?.includes(currentComponent.name)
        ) {
            setActiveTab('description');
        }
    }, [
        activeTab,
        componentDefinitionNames,
        currentAction,
        currentActionFetched,
        currentComponent?.name,
    ]);

    useEffect(() => {
        if (currentAction && currentActionFetched) {
            setCurrentActionName(currentAction.name);
        }
    }, [activeTab, currentAction, currentActionFetched]);

    const componentTabs = tabs.filter((tab) => {
        const {name} = tab;

        const componentHasConnection =
            currentComponent?.name &&
            componentDefinitionNames?.includes(currentComponent.name);

        if (
            (name === 'connection' && !componentHasConnection) ||
            (name === 'output' && !currentAction) ||
            (name === 'properties' && !currentAction?.properties?.length)
        ) {
            return;
        } else {
            return tab;
        }
    });

    return (
        <Dialog.Root
            open={nodeDetailsOpen}
            onOpenChange={() => setNodeDetailsOpen(!nodeDetailsOpen)}
            modal={false}
        >
            <Dialog.Portal>
                <Dialog.Content
                    className="fixed inset-y-0 bottom-2 right-2 top-16 z-10 w-screen max-w-[480px] overflow-hidden rounded-xl border-l bg-white shadow-lg"
                    onInteractOutside={(event) => event.preventDefault()}
                >
                    {currentComponent ? (
                        <div className="flex h-full flex-col divide-y divide-gray-100 bg-white shadow-xl">
                            <Dialog.Title className="flex content-center items-center p-4 text-lg font-medium text-gray-900">
                                {currentNode.label}

                                <span className="mx-2 text-sm text-gray-500">
                                    ({currentNode.name})
                                </span>

                                {currentComponent?.description && (
                                    <Tooltip
                                        text={currentComponent?.description}
                                    >
                                        <InfoCircledIcon className="h-4 w-4" />
                                    </Tooltip>
                                )}

                                <Button
                                    aria-label="Close panel"
                                    className="ml-auto"
                                    displayType="icon"
                                    icon={
                                        <Cross1Icon
                                            className="h-3 w-3 cursor-pointer text-gray-900"
                                            aria-hidden="true"
                                        />
                                    }
                                    onClick={() => setNodeDetailsOpen(false)}
                                />
                            </Dialog.Title>

                            <div className="flex h-full flex-col">
                                {!!currentComponent?.actions?.length && (
                                    <CurrentActionSelect
                                        actions={currentComponent.actions}
                                        description={currentAction?.description}
                                        handleValueChange={setCurrentActionName}
                                        value={currentActionName}
                                    />
                                )}

                                {componentTabs.length > 1 && (
                                    <div className="flex justify-center pt-4">
                                        {componentTabs.map((tab) => (
                                            <Button
                                                className={twMerge(
                                                    'grow justify-center whitespace-nowrap rounded-none border-0 border-b-2 border-gray-200 bg-white px-3 py-2 text-sm font-medium text-gray-500 hover:border-blue-500 hover:text-blue-500 focus:border-blue-500 focus:text-blue-500 focus:outline-none',
                                                    activeTab === tab.name &&
                                                        'border-blue-500 text-blue-500 hover:text-blue-500'
                                                )}
                                                key={tab.name}
                                                label={tab.label}
                                                name={tab.name}
                                                onClick={() =>
                                                    setActiveTab(tab.name)
                                                }
                                            />
                                        ))}
                                    </div>
                                )}

                                <div className="relative h-full overflow-y-auto">
                                    <div className="absolute left-0 top-0 h-full w-full">
                                        {activeTab === 'description' && (
                                            <DescriptionTab
                                                component={currentComponent}
                                            />
                                        )}

                                        {activeTab === 'properties' &&
                                            !!currentAction?.properties
                                                ?.length && (
                                                <Properties
                                                    actionName={
                                                        currentActionName
                                                    }
                                                    customClassName="p-4 overflow-y-auto"
                                                    properties={
                                                        currentAction.properties
                                                    }
                                                />
                                            )}

                                        {activeTab === 'connection' &&
                                            currentComponent.connection && (
                                                <ConnectionTab
                                                    component={currentComponent}
                                                />
                                            )}

                                        {activeTab === 'output' &&
                                            currentAction?.outputSchema && (
                                                <OutputTab
                                                    outputSchema={
                                                        currentAction.outputSchema
                                                    }
                                                />
                                            )}
                                    </div>
                                </div>
                            </div>

                            <div className="mt-auto flex p-4">
                                <Select
                                    defaultValue={currentComponent.version.toString()}
                                    options={[
                                        {label: 'v1', value: '1'},
                                        {label: 'v2', value: '2'},
                                        {label: 'v3', value: '3'},
                                    ]}
                                />
                            </div>
                        </div>
                    ) : (
                        <div className="flex w-full justify-center p-4">
                            <span className="text-gray-500">
                                Something went wrong 👾
                            </span>
                        </div>
                    )}
                </Dialog.Content>
            </Dialog.Portal>
        </Dialog.Root>
    );
};

export default NodeDetailsDialog;

package org.onlab.onos.cluster;

import java.util.Set;

import org.onlab.onos.net.DeviceId;
import org.onlab.onos.net.MastershipRole;

/**
 * Manages inventory of mastership roles for devices, across controller
 * instances; not intended for direct use.
 */
public interface MastershipStore {

    // three things to map: NodeId, DeviceId, MastershipRole

    /**
     * Requests role of the local node for the specified device.
     *
     * @param deviceId device identifier
     * @return established or newly negotiated mastership role
     */
    MastershipRole requestRole(DeviceId deviceId);

    /**
     * Returns the role of a device for a specific controller instance.
     *
     * @param nodeId   the instance identifier
     * @param deviceId the device identifiers
     * @return the role
     */
    MastershipRole getRole(NodeId nodeId, DeviceId deviceId);

    /**
     * Returns the master for a device.
     *
     * @param deviceId the device identifier
     * @return the instance identifier of the master
     */
    NodeId getMaster(DeviceId deviceId);

    /**
     * Returns the devices that a controller instance is master of.
     *
     * @param nodeId the instance identifier
     * @return a set of device identifiers
     */
    Set<DeviceId> getDevices(NodeId nodeId);

    /**
     * Sets a device's role for a specified controller instance.
     *
     * @param nodeId   controller instance identifier
     * @param deviceId device identifier
     * @param role     new role
     * @return a mastership event
     */
    MastershipEvent setRole(NodeId nodeId, DeviceId deviceId,
                            MastershipRole role);
}

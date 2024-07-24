package DesignSplitwise.Group;

import DesignSplitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList = new ArrayList<>();
    }
    public void createNewGroup(int groupId, String groupName, User createdByUser) {
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.addMember(createdByUser);
        groupList.add(group);
    }
    public Group getGroup(int groupId) {
        for (Group group : groupList) {
            if (group.getGroupId() == groupId) {
                return group;
            }
        }
        return null;
    }
}

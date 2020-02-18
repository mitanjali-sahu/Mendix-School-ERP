package mendixsso.implementation.utils;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.ISession;
import mendixsso.proxies.ForeignIdentity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ForeignIdentityUtils {

    private static final Set<String> UUID_LOCKS = new HashSet<>();

    public static void lockForeignIdentity(String uuid) throws InterruptedException {
        synchronized (UUID_LOCKS) {
            while (UUID_LOCKS.contains(uuid))
                UUID_LOCKS.wait();
            UUID_LOCKS.add(uuid);
        }
    }

    public static void unlockForeignIdentity(String uuid) {
        synchronized (UUID_LOCKS) {
            UUID_LOCKS.remove(uuid);
            UUID_LOCKS.notifyAll();
        }
    }

    public static ForeignIdentity retrieveForeignIdentity(IContext context, ISession session) {
        return MendixUtils.retrieveSingleObjectFromDatabase(context, ForeignIdentity.class, "//%s[%s = $userId]",
                new HashMap<String, Object>() {{
                    put("userId", session.getUser(context).getMendixObject().getId());
                }},
                ForeignIdentity.entityName,
                ForeignIdentity.MemberNames.ForeignIdentity_User.toString()
        );
    }
}

package autesty;

import org.apache.curator.test.TestingCluster;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;

import static java.lang.System.clearProperty;
import static java.lang.System.setProperty;

class ZkClusterExtension implements BeforeAllCallback, AfterAllCallback {
    private static final String CONN_STR_PROP = "zookeeper.connect-string";
    private TestingCluster zkCluster;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        zkCluster = new TestingCluster(1);
        zkCluster.start();
        setProperty(CONN_STR_PROP, zkCluster.getConnectString());
    }

    @Override
    public void afterAll(ExtensionContext context) throws IOException {
        if (zkCluster != null) {
            clearProperty(CONN_STR_PROP);
            zkCluster.close();
        }
    }
}

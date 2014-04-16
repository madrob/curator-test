/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package madrob;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MiniWrapperTest {

  MiniWrapper mini;

  @Before
  public void setUp() {
    mini = new MiniWrapper();
  }

  @Test
  public void test() throws IOException, KeeperException, InterruptedException {
    mini.run();
    assertNotNull(mini.zk);

    ZooKeeper zk = new ZooKeeper(mini.zk.getConnectString(), 60000, null);
    assertNotNull(zk.exists("/", false));
  }

  @After
  public void teardown() throws IOException {
    mini.close();
  }

}

/*
 * Copyright 2013-2020 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.whispersystems.textsecuregcm.workers;

import io.dropwizard.core.cli.Command;
import io.dropwizard.core.setup.Bootstrap;
import java.util.Base64;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import org.signal.libsignal.zkgroup.ServerPublicParams;
import org.signal.libsignal.zkgroup.ServerSecretParams;

public class ZkParamsCommand extends Command {

  public ZkParamsCommand() {
    super("zkparams", "Generates server zkparams");
  }

  @Override
  public void configure(Subparser subparser) {

  }

  @Override
  public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
    ServerSecretParams serverSecretParams = ServerSecretParams.generate();
    ServerPublicParams serverPublicParams = serverSecretParams.getPublicParams();

    System.out.println("Public: " + Base64.getEncoder().withoutPadding().encodeToString(serverPublicParams.serialize()));
    System.out.println("Private: " + Base64.getEncoder().withoutPadding().encodeToString(serverSecretParams.serialize()));
  }

}

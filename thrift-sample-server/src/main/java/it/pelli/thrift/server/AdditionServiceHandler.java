package it.pelli.thrift.server;

import org.apache.thrift.TException;

public class AdditionServiceHandler implements AdditionService.Iface {

 @Override
 public int add(int n1, int n2) throws TException {
  return n1 + n2;
 }

 public void ping() {
  System.out.println("ping()");
 }

}

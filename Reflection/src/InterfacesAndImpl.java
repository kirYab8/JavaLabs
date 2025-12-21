// Интерфейсы из задания
interface SomeInterface {
  void doSomething();
}

interface SomeOtherInterface {
  void doSomeOther();
}

class SomeImpl implements SomeInterface {
  public void doSomething() { System.out.println("A"); }
}

class OtherImpl implements SomeInterface {
  public void doSomething() { System.out.println("B"); }
}

class SODoer implements SomeOtherInterface {
  public void doSomeOther() { System.out.println("C"); }
}
#include <iostream>
#include <string>
#include "Animal.cpp"
#include "Dog.cpp"
#include "Parrot.cpp"
#include "Snake.cpp"

using namespace std;

int main(int argc, char** argv)
    {
    Dog dog(4,0,1,0,"A","chihuahua");
    cout<<"Dog"<<endl;
    dog.printDetails();
    dog.makeSound();

    Parrot parrot(2,1,0,1,"Red");
    cout<<"Parrot"<<endl;
    dog.printDetails();
    dog.makeSound();

    Snake snake(0,0,0,1,1);
    cout<<"Snake"<<endl;
    dog.printDetails();
    dog.makeSound();

    return 0;
    }

#include <iostream>
#include <string>

using namespace std;

class Animal
    {
    public:
        int legcount = 0;
        bool canFly = 0;
        bool canSwim = 0;
        bool laysEggs = 0;

        virtual void makeSound();
        void printDetails()
            {
            cout<<"has "<<legcount<<" legs."<<endl;
            if(canFly == 0)
                {
                cout<<"can't fly."<<endl;
                }
            else
                {
                cout<<"can fly."<<endl;
                }

            if(canSwim == 0)
                {
                cout<<"can't swim."<<endl;
                }
            else
                {
                cout<<"can swim."<<endl;
                }

            if(laysEggs == 0)
                {
                cout<<"doesn't lay eggs."<<endl;
                }
            else
                {
                cout<<"lays eggs."<<endl;
                }
            }
    };

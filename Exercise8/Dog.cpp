class Dog : public Animal
    {
    public:
        char[] name;
        char[] breed;
        Dog(int leg, bool bFly, bool bSwim, bool bEggs, string inputName, string inputBreed)
            {
            legcount = leg;
            canFly = fly;
            canSwim = swim;
            laysEggs = bEggs;
            name = inputName;
            breed = inputBreed;
            }
    };

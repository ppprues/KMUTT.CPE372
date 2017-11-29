class Snake : public Animal
    {
    public:
        bool isPoisonous;
        Snake(int leg, bool bFly, bool bSwim, bool bEggs, bool bPoisonous)
            {
            legcount = leg;
            canFly = fly;
            canSwim = swim;
            laysEggs = bEggs;
            isPoisonous = bPoisonous;
            }
    };

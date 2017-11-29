class Parrot : public Animal
    {
    public:
        string color;
        Parrot(int leg, bool fly, bool swim, bool eggs, string inputColor)
            {
            legcount = leg;
            canFly = fly;
            canSwim = swim;
            laysEggs = bEggs;
            color = inputColor;
            }
    };

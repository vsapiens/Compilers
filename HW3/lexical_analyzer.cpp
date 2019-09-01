#include <cstdio>
#include <string>

class Token
{
};
int main(int argc, char *argv[])
{
    string input;
    while (true)
    {
        scanf("%s", &input)
        // TODO: Process the input with the transition matrix
        // TODO: Display the resulting token to the user
    }

    int ERROR = 999;
    int[][] transitionMatrix;
    transitionMatrix = new int[][]{

        /*State 0*/ {0, 1, ERROR, 5, 0, ERROR},
        /*State 1*/ {ERROR, ERROR, 2, ERROR, ERROR, ERROR},
        /*State 2*/ {ERROR, ERROR, 3, 3, ERROR, ERROR},
        /*State 3*/ {104, 104, ERROR, ERROR, 104, 104},
        /*State 5*/ {106, 106, 106, 5, 106, 106}

    };
    while (index < string.length())
    {
        value = new StringBuilder();
        do
        {
            c = string.charAt(index);
            index++;
            state = transitionMatrix[state][filter(c)];
            if (state != 0)
            {
                value.append(c);
            }
        } while (index < string.length() && state < 100);
        // Do something with the string. We know it has beenaccepted.}
        return 0;
    }
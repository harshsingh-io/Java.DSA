#include<stdio.h>
#include<windows.h>//gotoxy()
#include<conio.h>//use for delay(),getch()etc
#include<ctype.h>//use for toupper(), tolower(),etc
#include<string.h>//use for strcmp()etc
#include<stdlib.h>
char ans = 0;
int ok;
int b,valid = 0;
// Function Declaration
void WelcomeScreen(void);//WelcomeScreen
void Title(void);
void MainMenu(void);
void LoginScreen(void);
void Add_rec(void);
void func_list();
void Search_rec(void);
void Edit_rec(void);
void Dlt_rec(void);
void ex_it(void);
void gotoxy(short x,short y)
{
    COORD pos = {x,y};//set co-ordinates in {x,y}.
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),pos);
}
//list of global variable
struct patient
{
    int age;
    char Gender;
    char First_Name[20];
    char Last_Name[20];
    char Contact_no[15];
    char Address[30];
    char Email[30];
    char Doctor[20];
    char Problem[20];
};
struct patient p, temp_c; //structure variables assigned
int main()
{
    WelcomeScreen();//use to call WelcomeScreen function
    Title(); // use to call Title function
    LoginScreen();// use to call Menu function
}
/* *****************************WelcomeScreen ************** */
void WelcomeScreen(void)//function for welcome Screen
{
printf("\n\n\n\n\n\n\n\t\t\t############################");
printf("\n\t\t\t\t WELCOME To \t\t");
printf("\n\t\t\t HOSPITAL MANAGEMENT SYSTEM");
printf("\n\t\t\t\t################################");
printf("\n\n\n\n\n Press any key to continue......\n");
getch();// Hold the screen and wait for user to print a key and does not return anything.
system("cls");//use to clear screen
}
/* ******************************Title Screen ***************** */
void Title(void)
{
    printf("\n\n\t\t--------------------------------------");
    printf("\n\t\t\t\t       BHOPAL HOSPITAL             ");
    printf("\n\t\t-----------------------------------------");
}

//****************************** Login Screen *******************
void LoginScreen(void)
{
    int e = 0;
    char Username[15];
    char Password[15];
    char original_Username[25]="aish";
    char original_Password[15]="1234";
    do
    {
        printf("\n\n\n\n\n\t\t\t\t Enter your Username and password : ");
        printf("\n\n\n\t\t\t\t USERNAME:");
        scanf("%s",&Username);
        printf("\n\n\t\t\t\t\t PASSWORD");
        scanf("%s",&Password);
        if(strcmp(Username,original_Username)==0 && strcmp(Password,original_Password)==0)
        {
            printf("\n\n\n\t\t\t\t\t...Login Successful...");
            getch(); // hold the screen
            MainMenu();//call MainMenu function
            break;
        }
        else
        {
            printf("\n\t\t\t Password is incorrect:(Try Again:)");
            e++;
            getch();
        }
    }while(e<=2);
if(e>2)
{
    printf("You have cross the limit. You cannot login.");
    getch();
    ex_it();
}
system("cls");
}
// ****************************** Main Menu *********************
void MainMenu(void)
{
    system("cls");
    int choose;
    Title();
    printf("\n\n\n\n\n\t\t\t 1.Add Patient Record\n");
    printf("\n\t\t\t\t 2.List Patients Record\n");
    printf("\n\t\t\t\t 3.Search Patient Record");
    printf("\n\t\t\t\t 4.Edit Patient Record\n");
    printf("\n\t\t\t\t 5.Delete Patient Record \n");
    printf("\n\t\t\t\t 6.Exit \n");
    printf("\n\n\n \n\t\t\t\t Choose from 1 to 6: ");

    scanf("%d",&choose);
    switch(choose)//Add_rec function is called
    {
    case 1:
        Add_rec();
        break;
    case 2:
        func_list();
        break;
    case 3:
        Search_rec();
        break;
    case 4:
        Edit_rec();
        break;
    case 5:
        Dlt_rec();
        break;
    case 6:
        ex_it();
        break;
    default:
        printf("\t\t\t Invalid entry. Please enter right option");
        system("cls");
        MainMenu();
        getch();
    }
}
// ******************************* Exit Screen ****************************
void ex_it(void)
{
    system("cls");
    Title();
    printf("\n\n\n\n\n\t\t\t THANK YOU FOR VISITING :");
    getch();
}
//******************************* Add Record ****************************
void Add_rec(void)
{
    system("cls");
    Title();
    //List of variables
    char ans;
    FILE *ek; //file pointer
    ek= fopen("Record.dat","a");
    printf("\n\n\t\t\t!!!!!!!!!!!Add Patients Record !!!!!!!\n");
    /* ********************************** First Name ********************* */
    A: //label
    printf("\n\t\t\t First Name: ");
    scanf("%s",p.First_Name); // structure variable
    p.First_Name[0]= toupper(p.First_Name[0]); // UPPER CASE
    if(strlen(p.First_Name)>20||strlen(p.First_Name)<3)
    {
        printf("\n\t Invalid :(\t The max range for the first name is 20 and min range is 2");
        goto A;
    }
    else
    {
        for(b=0;b<strlen(p.First_Name);b++)
        {
            if(isalpha(p.First_Name[b]))//check alphabets
            {
                valid = 1;
            }
            else
            {
                valid = 0;
                break;
            }
        }
        if(!valid){
            printf("\n\t\t First name contain Invalid character :(Enter again :)");
            goto A;
        }
    }
    //************************************ Last Name ************************
    B:
     printf("\n\t\t\t Last Name: ");
    scanf("%s",p.Last_Name); // structure variable
    p.Last_Name[0]= toupper(p.Last_Name[0]); // UPPER CASE
    if(strlen(p.Last_Name)>20||strlen(p.Last_Name)<3)
    {
        printf("\n\t Invalid :(\t The max range for the last name is 20 and min range is 2");
        goto B;
    }
    else
    {
        for(b=0;b<strlen(p.Last_Name);b++)
        {
            if(isalpha(p.Last_Name[b]))//check alphabets
            {
                valid = 1;
            }
            else
            {
                valid = 0;
                break;
            }
        }
        if(!valid){
            printf("\n\t\t Last Name contain Invalid character :(Enter again :)");
            goto B;
        }
    }
    fflush(stdin);
    // ****************************Gender *********************************
    do
    {
        printf("\n\t\t\t Gender[F/M]:");
        scanf("%c",&p.Gender);
        if(toupper(p.Gender)=='M'||toupper(p.Gender)=='F');
        {
            ok =1;
        }
        if(!ok)
        {
            printf("\n\t\t Gender contain Invalid character :(Enter either F or M):");
        }
    }while(!ok);

    fflush(stdin);
// *****************************Age *************************
    printf("\n\t\t\t Age:");
    scanf("%d",&p.age);
// *******************************Address ********************

    C:
    printf("\n\t\t\t Address: ");
    scanf("%s",p.Address);
    p.Address[0]=toupper(p.Address[0]);
    if(strlen(p.Address)>30||strlen(p.Address)<3)
    {
        printf("\n\t Invalid :(\t The max range for address is 30 and min range is 4");
        goto C;
    }
    //****************************Contact No. ************************

    D:
    printf("\n\t\t\t Contact_no ");
    scanf("%s",p.Contact_no);
    p.Contact_no[0]=toupper(p.Contact_no[0]);
    if(strlen(p.Contact_no)>15||strlen(p.Address)<5)
    {
        printf("\n\t Invalid :(\t The max range for Contact_no is 30 and min range is 4");
        goto D;
    }
    else
    {
    for(b=0;b<strlen(p.Contact_no);b++)
    {
        if(isdigit(p.Contact_no[b]))//check alphabets
        {
            valid = 1;
        }
        else
        {
            valid = 0;
            break;
        }
    }
    if(!valid){
        printf("\n\t\t  contain Invalid character :(Enter again :)");
        goto D;
    }
    }
// ********************* EMAIL *****************
    do
    {
        printf("\n\t\t\t\t Email:");
        scanf("%s",p.Email);
        if(strlen(p.Email)>30||strlen(p.Email)<8)
        {
            printf("\n\t Invalid:(\t The max range for email is 30 and min range is 8");
        }
    }while(strlen(p.Email)>30||strlen(p.Email)<8);
//************************ Problem **********************
 E:
     printf("\n\t\t\t Problem: ");
    scanf("%s",p.Problem); // structure variable
    p.Problem[0]= toupper(p.Problem[0]); // UPPER CASE
    if(strlen(p.Problem)>15||strlen(p.Problem)<3)
    {
        printf("\n\t Invalid :(\t The max range for the Problem is 15 and min range is 2");
        goto E;
    }
    else
    {
        for(b=0;b<strlen(p.Problem);b++)
        {
            if(isalpha(p.Problem[b]))//check alphabets
            {
                valid = 1;
            }
            else
            {
                valid = 0;
                break;
            }
        }
        if(!valid){
            printf("\n\t\t Problem contain Invalid character :(Enter again :)");
            goto E;
        }
    }
//***********************************Prescribed Doctor**************
 F:
     printf("\n\t\t\t Prescribed Doctor: ");
    scanf("%s",p.Doctor); // structure variable
    p.Doctor[0]= toupper(p.Doctor[0]); // UPPER CASE
    if(strlen(p.Doctor)>15||strlen(p.Doctor)<3)
    {
        printf("\n\t Invalid :(\t The max range for the Doctor is 15 and min range is 2");
        goto F;
    }
    else
    {
        for(b=0;b<strlen(p.Doctor);b++)
        {
            if(isalpha(p.Doctor[b]))//check alphabets
            {
                valid = 1;
            }
            else
            {
                valid = 0;
                break;
            }
        }
        if(!valid){
            printf("\n\t\t Doctor contain Invalid character :(Enter again :)");
            goto F;
        }
    }
    fprintf(ek,"%s %s %c %d %s %s %s %s %s \n",p.First_Name,p.Last_Name,p.Gender,p.age,p.Address,p.Contact_no,p.Email,p.Problem,p.Doctor);
    printf("\n\n\t\t\t ....... INFORMATION RECORD SUCCESSFUL ......");
    fclose(ek);
    sd:
    getch();
    printf("\n\n\t\t\t Do you want to add more[Y/N]");
    scanf("%c",&ans);
    if(toupper(ans)=='Y')
    {
        Add_rec();
    }
    else if(toupper(ans)=='N')
    {
        printf("\n\t\t Thank you");
        getch();
        MainMenu();
    }
    else
    {
        printf("\n\t\t Invalid Input");
        goto sd;
    }
}
//**************************************** View Record *********************
void func_list()
{
    int row;
    system("cls");
    Title();
    FILE *ek;
    ek = fopen("Record.dat","r");
    printf("\n\n\t\t\t!!!!!!!!!!!!!!!!!!!!!!! List Patients Record !!!!!!!!\n");
    gotoxy(1,15);
    printf("Full Name");
    gotoxy(20,15);
    printf("Gender");
    gotoxy(32,15);
    printf("Age");
    gotoxy(37,15);
    printf("Address");
    gotoxy(49,15);
    printf("Contact No.");
    gotoxy(64,15);
    printf("Email");
    gotoxy(88,15);
    printf("Problem");
    gotoxy(98,15);
    printf("Prescribed Doctor\n");
    printf("=================================================================================");
    row = 17;
    while(fscanf(ek,"%s %s %c %d %s %s %s %s %s \n",p.First_Name, p.Last_Name,&p.Gender,&p.age,p.Address,p.Contact_no,p.Email,p.Problem,p.Doctor)!=EOF)
    {
        gotoxy(1,row);
        printf("%s %s",p.First_Name,p.Last_Name);
        gotoxy(20,row);
        printf("%c",p.Gender);
        gotoxy(32,row);
        printf("%d",p.age);
        gotoxy(37,row);
        printf("%s",p.Address);
        gotoxy(49,row);
        printf("%s",p.Contact_no);
        gotoxy(64,row);
        printf("%s",p.Email);
        gotoxy(88,row);
        printf("%s",p.Problem);
        gotoxy(98,row);
        printf("%s",p.Doctor);
        row++;
    }
    fclose(ek);
    getch();
    MainMenu();
}
void Search_rec(void)
{
    int row;
    char name[20];
    system("cls");
    Title();
    FILE *ek;
    ek = fopen("Record.dat","r");
    printf("\n\n\t\t\t !!!!!!!!!!!!!!!!!!!!!!!!Search Patients Record !!!!!!!!!!!");
    gotoxy(12,8);
    printf("\n Enter Patients Name to be viewed: ");
    scanf("%s",name);
    fflush(stdin);// use after string read
    name[0]= toupper(name[0]);
    row = 19;
     while(fscanf(ek,"%s %s %c %d %s %s %s %s %s \n",p.First_Name, p.Last_Name
                ,&p.Gender,&p.age,p.Address,p.Contact_no,p.Email,
                p.Problem,p.Doctor)!=EOF)
                {
                    if(strcmp(p.First_Name,name)==0)
                    {
                        gotoxy(1,15);
                        printf("Full Name");
                        gotoxy(20,15);
                        printf("Gender");
                        gotoxy(32,15);
                        printf("Age");
                        gotoxy(37,15);
                        printf("Address");
                        gotoxy(49,15);
                        printf("Contact No.");
                        gotoxy(64,15);
                        printf("Email");
                        gotoxy(88,15);
                        printf("Problem");
                        gotoxy(98,15);
                        printf("Prescribed Doctor\n");
                        printf("===========================================");
                        gotoxy(1,row);
                        printf("%s %s",p.First_Name,p.Last_Name);
                        gotoxy(20,row);
                        printf("%c",p.Gender);
                        gotoxy(32,row);
                        printf("%d",p.age);
                        gotoxy(37,row);
                        printf("%s",p.Address);
                        gotoxy(49,row);
                        printf("%s",p.Contact_no);
                        gotoxy(64,row);
                        printf("%s",p.Email);
                        gotoxy(88,row);
                        printf("%s",p.Problem);
                        gotoxy(98,row);
                        printf("%s",p.Doctor);
                        break;
                    }
                }
                 if(strcmp(p.First_Name,name)!=0)
                 {
                    gotoxy(5,10);
                    printf("Record not found");
                    getch();
                 }
                 fclose(ek);
                 L:
                 getch();
                 printf("\n\n\t\t\t Do you want to view more[Y/N]");
                 scanf("%c",&ans);
                 if(toupper(ans)=='Y')
                 {
                     Search_rec();
                 }
                 else if(toupper(ans)=='N')
                 {
                     printf("\n\t\t Thank You");
                     getch();
                     MainMenu();
                 }
                 else
                 {
                     printf("\n\t Invalid Input.\n");
                     goto L;
                 }
}
void Edit_rec(void)
{
    FILE *ek,*ft;
    int i,b,valid = 0;
    char ch;
    char name[20];
    system("cls");
    Title();
    ft = fopen("temp.dat","w+");
    ek=fopen("Record.dat","r");
    if(ek==NULL)
    {
        printf("\n\t Cannot open file");
        getch();
        MainMenu();
    }
    printf("\n\n\t\t\t !!!!!!!!!!!!!!!!!!!! Edit Patient Record !!!!!!!!!!!!!\n");
    gotoxy(12,13);
    printf("Enter the First Name of the Patient:");
    scanf("%s",name);
    fflush(stdin);
    name[0]=toupper(name[0]);
    gotoxy(12,15);
    if(ft==NULL)
    {
        printf("\n Cannot open file");
        getch();
        MainMenu();
    }
    while(fscanf(ek,"%s %s %c %d %s %s %s %s %s \n",p.First_Name, p.Last_Name
                ,&p.Gender,&p.age,p.Address,p.Contact_no,p.Email,
                p.Problem,p.Doctor)!=EOF)
        {
            if(strcmp(p.First_Name,name)==0)
            {
                valid =1;
                gotoxy(25,17);
                printf("********Existing Record********\n");
                gotoxy(10,19);
                printf("%s %s %c %d %s %s %s %s %s \n",p.First_Name, p.Last_Name
                ,p.Gender,p.age,p.Address,p.Contact_no,p.Email,
                p.Problem,p.Doctor);
                gotoxy(12,22);
                printf("Enter New First Name:");
                scanf("%s",p.First_Name);
                gotoxy(12,24);
                printf("Enter Last Name: ");
                scanf("%s",p.Last_Name);
                gotoxy(12,26);
                printf("Enter Gender: ");
                scanf("%c",&p.Gender);
                p.Gender=toupper(p.Gender);
                gotoxy(12,28);
                printf("Enter age:");
                scanf("%d",&p.age);
                gotoxy(12,30);
                printf("Enter Address: ");
                scanf("%s",p.Address);
                p.Address[0]=toupper(p.Address[0]);
                gotoxy(12,32);
                printf("Enter Contact no:");
                scanf("%s",p.Contact_no);
                gotoxy(12,34);
                printf("Enter New Email:");
                scanf("%s",p.Email);
                gotoxy(12,36);
                printf("Enter Problem: ");
                scanf("%s",p.Problem);
                p.Problem[0]=toupper(p.Problem[0]);
                gotoxy(12,38);
                printf("Enter Doctor: ");
                scanf("%s",p.Doctor);
                p.Doctor[0]=toupper(p.Doctor[0]);
                printf("\n Press U character for the updating operation");
                ch= getche();//get character
                if(ch=='u'||ch=='U')
                {
                     fprintf(ft,"%s %s %c %d %s %s %s %s %s \n",p.First_Name,p.Last_Name,p.Gender,p.age,p.Address,p.Contact_no,p.Email,p.Problem,p.Doctor);
                     printf("\n\n\t\t\t Patient record updated successfully....");
                }
            }
            else{
                fprintf(ft,"%s %s %c %d %s %s %s %s %s \n",p.First_Name,p.Last_Name,p.Gender,p.age,p.Address,p.Contact_no,p.Email,p.Problem,p.Doctor);
            }
        }
        if(!valid)
        {
            printf("\n\t\t NO RECORD FOUND....");
        }
        fclose(ft);
        fclose(ek);
        remove("Record.dat");
        rename("temp2.dat","Record.dat");
        getch();
        MainMenu();
}
void Dlt_rec()
{
    char name[20];
    int found = 0;
    system("cls");
    Title();
    FILE *ek,*ft;
    ft = fopen("temp2.dat","w+");
    ek=fopen("Record.dat","r");
    printf("\n\n\t\t\t!!!!!!!!!!!! Delete Patient Record !!!!!!!!!!\n");
    gotoxy(12,8);
    printf("\n Enter Patient Name to delete");
    fflush(stdin);
    gets(name);
    name[0]=toupper(name[0]);
    while(fscanf(ek,"%s %s %c %d %s %s %s %s %s \n",p.First_Name, p.Last_Name
                ,&p.Gender,&p.age,p.Address,p.Contact_no,p.Email,
                p.Problem,p.Doctor)!=EOF)
        {
            if(strcmp(p.First_Name,name)!=0)
            {
                fprintf(ft,"%s %s %c %d %s %s %s %s %s \n",p.First_Name,p.Last_Name,p.Gender,p.age,p.Address,p.Contact_no,p.Email,p.Problem,p.Doctor);
            }
            else{
                printf("%s %s %c %d %s %s %s %s %s \n",p.First_Name,p.Last_Name,p.Gender,p.age,p.Address,p.Contact_no,p.Email,p.Problem,p.Doctor);
                found =1;
            }
        }
        if(found==0)
        {
            printf("\n\n\t\t\t Record not found......:");
            getch();
            MainMenu();
        }
        else
        {
            fclose(ek);
            fclose(ft);
            remove("Record.dat");
            rename("temp2.dat","Record.dat");
            printf("\n\n\t\t\t Record deleted successfully");
            getch();
            MainMenu();
        }
}

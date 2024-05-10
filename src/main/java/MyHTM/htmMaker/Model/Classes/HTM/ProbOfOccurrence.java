package MyHTM.htmMaker.Model.Classes.HTM;
//In the future, the number of probability levels can be defined by the user
//todo: allow customization of probability levels
public enum ProbOfOccurrence {
    ZeroToD_Minus3, //Improbable
    D_Minus3ToD_Minus2, //Rare
    D_Minus2ToD_Minus1, //Occasional
    D_Minus1ToHalf, //Frequent
    HalfToOne //Probable
}

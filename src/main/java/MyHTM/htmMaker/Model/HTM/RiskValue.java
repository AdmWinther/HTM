package MyHTM.htmMaker.Model.HTM;

public enum RiskValue {
    R1, //green risk
    R2, //yellow risk
    R3; //red risk

    //in the future, the number of risk levels can be defined by the user
    //in the future, the risk value calculation based on the severity and probability can be defined by the user
    //todo: allow customization of risk levels
    //todo: allow customization of risk value calculation
    public static RiskValue getRiskValue(HarmSeverity harmSeverity, ProbOfOccurrence probOfOccurrence) {
        if(harmSeverity == null || probOfOccurrence == null) throw new IllegalArgumentException("HarmSeverity and ProbOfOccurrence cannot be null");

        if (harmSeverity == HarmSeverity.Negligible) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Minor && probOfOccurrence == ProbOfOccurrence.ZeroToD_Minus3) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Minor && probOfOccurrence == ProbOfOccurrence.D_Minus3ToD_Minus2) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Minor && probOfOccurrence == ProbOfOccurrence.D_Minus2ToD_Minus1) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Minor && probOfOccurrence == ProbOfOccurrence.D_Minus1ToHalf) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Minor && probOfOccurrence == ProbOfOccurrence.HalfToOne) {
            return RiskValue.R2;
        } else if (harmSeverity == HarmSeverity.Major && probOfOccurrence == ProbOfOccurrence.ZeroToD_Minus3) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Major && probOfOccurrence == ProbOfOccurrence.D_Minus3ToD_Minus2) {
            return RiskValue.R1;
        } else if (harmSeverity == HarmSeverity.Major && probOfOccurrence == ProbOfOccurrence.D_Minus2ToD_Minus1) {
            return RiskValue.R2;
        } else if (harmSeverity == HarmSeverity.Major && probOfOccurrence == ProbOfOccurrence.D_Minus1ToHalf) {
            return RiskValue.R2;
        } else if (harmSeverity == HarmSeverity.Major && probOfOccurrence == ProbOfOccurrence.HalfToOne) {
            return RiskValue.R2;
        } else if (harmSeverity == HarmSeverity.Critical && probOfOccurrence == ProbOfOccurrence.ZeroToD_Minus3) {
            return RiskValue.R2;
        } else if (harmSeverity == HarmSeverity.Critical && probOfOccurrence == ProbOfOccurrence.D_Minus3ToD_Minus2) {
            return RiskValue.R2;
        } else if (harmSeverity == HarmSeverity.Critical && probOfOccurrence == ProbOfOccurrence.D_Minus2ToD_Minus1) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Critical && probOfOccurrence == ProbOfOccurrence.D_Minus1ToHalf) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Critical && probOfOccurrence == ProbOfOccurrence.HalfToOne) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Mortal && probOfOccurrence == ProbOfOccurrence.ZeroToD_Minus3) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Mortal && probOfOccurrence == ProbOfOccurrence.D_Minus3ToD_Minus2) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Mortal && probOfOccurrence == ProbOfOccurrence.D_Minus2ToD_Minus1) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Mortal && probOfOccurrence == ProbOfOccurrence.D_Minus1ToHalf) {
            return RiskValue.R3;
        } else if (harmSeverity == HarmSeverity.Mortal && probOfOccurrence == ProbOfOccurrence.HalfToOne) {
            return RiskValue.R3;
        }
        return null;
    }
}

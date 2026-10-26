public class Stats_13 { public static <N extends Number> double average(N[] a){double s=0;for(N x:a)s+=x.doubleValue();return s/a.length;} }

class Solution {
    public String longestPalindrome(String s) {
        
        if( s== null || s.length()<=1 ) {
            return s ; 
        }
        
         String str = "#" ;         
        for(char c: s.toCharArray()) {
            str = str + c ; 
            str = str + '#' ;
        }
        
        int[] P = new int[str.length()]; 
		int C=0, R=0;  int maxLength = -1; int maxCentre = -1;
		
		for(int i=1; i<str.length()-1 ; i++ ) {
			
			int mirror = 2*C - i; 
			
			if(i < R) {
				P[i] = Math.min(R-i, P[mirror]) ; 
			}
			
			
			if( (i + (1 + P[i])) < str.length() && (i - (1+ P[i] ) ) >= 0 ) {
			
				while( str.charAt(i + (1 + P[i])) == str.charAt( i - ( 1 + P[i] )) ) {  	
					P[i]++ ;
					
					if( (i + (1 + P[i])) > str.length()-1 || (i - (1+ P[i] ) ) < 0 ) {
						break ; 
					}
					
				}
			}	
				if( i + P[i] > R ) {
					C = i; 
					R = i + P[i] ; 
				}
            
                if(P[i] > maxLength){
                    maxLength = P[i] ;
                    maxCentre = C; 
                }
				
			}

        
        String a = str.substring(maxCentre-maxLength, maxCentre+maxLength+1) ; 
        
       // a.replace("#", "") ;
      
        String result = "" ;
        
        for(char c1 : a.toCharArray()) {
            if( c1 != '#') {
                result = result + c1 ;
            }         
        }
        
        return result ;
    }
}

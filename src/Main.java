public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        String in = "";
        String out = "";
        int key = 0;
        String alg = "shift";
        Encryption e = new Encryption();

        for (int i=0; i<args.length; i++) {
            switch (args[i]) {
                case "-mode": mode = args[i+1];
                    break;
                case "-data": data = args[i+1];
                    break;
                case "-key": key = Integer.parseInt(args[i+1]);
                    break;
                case "-in": in = args[i+1];
                    break;
                case "-out": out = args[i+1];
                    break;
                case "-alg": alg = args[i+1];
                    break;
            }

        }

        switch (alg) {
            case "shift": e.setMethod(new Shift(key));
                break;
            case "unicode": e.setMethod(new Unicode(key));
                break;
        }

        if(!in.equals("") && data.equals("")) {
            if(mode.equals("enc")) {
                e.encryptFromFile(in,out);
            } else if (mode.equals("dec")) {
                e.decryptFromFile(in,out);
            } else {
                System.out.println("Incorrect method");
            }
        } else {
            if(mode.equals("enc")) {
                e.encryptString(data, out);
            } else if (mode.equals("dec")) {
                e.decryptString(data, out);
            } else {
                System.out.println("Incorrect method");
            }
        }



    }
}

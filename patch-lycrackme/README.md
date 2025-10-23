# Monkey patching LyCrackMe

<details>
<summary><h3>👉 Original source of the CrackMe</h3></summary>

```java
import...

public class CrackMe {

static int[] _$$Y_sy76 = new int[]{7414755, 3219665, 175186692, 136322726, 136419744, 4066036, 15685602, 103481, 8331326, 14522496, 254443529, 117440530, 0x100000, 10066673, 0xEEE122, 0x421442, 1183806, 11019024, 140529167, 118489840, 19071234, 0xF00004, 3109537, 594494, 7406141, 9476832, 18812418, 9969838, 34803714, 3298805, 2302368, 15368608, 8916253, 9445024, 51519491, 31, 241696768, 7414181, 2299045, 39441, 9539087, 16392240, 0x9090090, 117641473, 258080912, 16115104, 0x120120, 0x10101A, 1183501, 7413822, 236060690, 257294849, 125830118, 66016, 8983278, 624289, 16609425, 14844138, 27270816, 239404033, 51389454, 7414690, 593951, 7709524, 9969409, 9847050, 118646528, 158482433, 0x1110011, 2299045, 2299045, 3739700};

    static String _$$as_OIsl(String _$s_String_) {
        byte[] _$$d_defaultBytes_ = _$s_String_.getBytes();
        MessageDigest _$$a_algorithm = null;
        try {
            _$$a_algorithm = MessageDigest.getInstance("SHA1");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        _$$a_algorithm.reset();
        _$$a_algorithm.update(_$$d_defaultBytes_);
        byte[] messageDigest = _$$a_algorithm.digest();
        StringBuffer hexString = new StringBuffer();
        int _$I_Index = 0;
        while (_$I_Index < messageDigest.length) {
            hexString.append(Integer.toHexString(0xFF & messageDigest[_$I_Index]));
            ++_$I_Index;
        }
        String _$f_Foo_ = messageDigest.toString();
        _$s_String_ = "" + hexString;
        return _$s_String_;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String _DEFF_$ = "ABDHGS61" + new Random().nextInt(10) + "51129018N00S";
        String _IX$ = "";
        String _DEFF_$2 = "2ODNWOF92H823ONEI2332";
        int _$$2341s = 0;
        boolean _$_$2edwb$ = true;
        block0: while (_$_$2edwb$) {
            int _yx$;
            int _stax$ = new Random().nextInt((int)Math.pow(Integer.parseInt("2ODNWOF92H823ONEI2332".substring(10, 12)), 3.0));
            if (_stax$ != Integer.parseInt(String.valueOf(_DEFF_$.charAt(_yx$ = 8)))) continue;
            int _index$ = _DEFF_$.length();
            while (_index$ > 1) {
                if (_index$ == Integer.parseInt("2ODNWOF92H823ONEI2332".substring(20))) {
                    _IX$ = String.valueOf(_IX$) + _DEFF_$.substring(_DEFF_$.indexOf("0") + 2, _DEFF_$.lastIndexOf("0") - _index$);
                    _$$2341s = (int)Math.pow(Integer.parseInt(_IX$), 2.0) / Integer.parseInt(_DEFF_$.substring(_DEFF_$.lastIndexOf("1") + 1, _DEFF_$.lastIndexOf("N"))) + Integer.parseInt(_DEFF_$.substring(11, 13)) - 2;
                    _$_$2edwb$ = false;
                    continue block0;
                }
                --_index$;
            }
        }
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        final JFrame _$$f_dwquig11__ = new JFrame("Ly-Crackme @Leyer");
        _$$f_dwquig11__.setLayout(new FlowLayout());
        final JPasswordField _$$p_Tetxta1Field_ = new JPasswordField(20);
        _$$f_dwquig11__.getContentPane().add(new JLabel("Key: "));
        _$$f_dwquig11__.getContentPane().add(_$$p_Tetxta1Field_);
        int _$$zaq1I1 = new Random().nextInt(_$$Y_sy76.length + 1);
        JLabel $$l_Label_ = new JLabel("X = " + _$$Y_sy76[_$$zaq1I1]);
        _$$f_dwquig11__.getContentPane().add($$l_Label_);
        _$$f_dwquig11__.setSize(500, 100);
        JButton _$$b__$$hsqqso_ = new JButton("Validar");
        String _$$c_Cor_ = "";
        int _$$i_INDEX_ = 0;
        while (_$$i_INDEX_ < _$$Y_sy76.length) {
            if (_$$Y_sy76[_$$i_INDEX_] == _$$Y_sy76[_$$zaq1I1]) {
                int index = 0;
                while (index < _$$i_INDEX_) {
                    _$$c_Cor_ = String.valueOf(_$$c_Cor_) + String.valueOf((byte)_$$Y_sy76[index]);
                    ++index;
                }
                _$$c_Cor_ = String.valueOf(CrackMe._$$as_OIsl(_$$c_Cor_)) + String.valueOf(Math.pow(_$$2341s, 2.0) / 6.0 - 36.0);
            }
            ++_$$i_INDEX_;
        }
        JLabel _$$s_poqh1120 = new JLabel("");
        _$$f_dwquig11__.getContentPane().add(_$$b__$$hsqqso_);
        final String _$$r_easte = _$$c_Cor_;
        _$$f_dwquig11__.getContentPane().setBackground(new Color(13, 124, 19, 12));
        _$$f_dwquig11__.getContentPane().add(_$$s_poqh1120);
        _$$f_dwquig11__.setResizable(false);
        _$$b__$$hsqqso_.setPreferredSize(new Dimension(120, 25));
        _$$f_dwquig11__.setLocationRelativeTo(null);
        _$$f_dwquig11__.setDefaultCloseOperation(3);
        _$$f_dwquig11__.setVisible(true);
        _$$b__$$hsqqso_.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent $$jawteventActionEvent) {
                String _$$I_pos123 = _$$p_Tetxta1Field_.getText();
                if (_$$I_pos123.equalsIgnoreCase(_$$r_easte)) {
                    JOptionPane.showMessageDialog(_$$f_dwquig11__, "Correcto!");
                } else {
                    JOptionPane.showMessageDialog(_$$f_dwquig11__, "Incorrecto!");
                }
            }
        });
    }
}
```
</details>

- actionPerformed, when the user clicks on the button, the value of the variable is investigated. `_$$r_easte`

---

## The premain

```bash
java -javaagent:patch-lycrackme-1.0.0-jar-with-dependencies.jar -jar vulnerable-target.jar
```

## The agentmain

```bash
java -jar /target/patch-lycrackme-1.0.0-jar-with-dependencies.jar PID
```
## IMPORTANT.

It is important to have the `tools.jar` coming from the JDK, not the JRE (which does not work to run the agent).

```bash
java -javaagent:agent-1.0.0.jar -jar Ly-CrackME.jar <1>
Execute premain method
██████████████████████ Ly-Crackme @Leyer ██████████████████▓▓█
█████████████████████▓▓▓▓▓▓█▓▓▓▒▓▓▒▓▓▓▓▓▓██████████████▓███▓██
███████ Key: ███                                       ███████
██████▓▒░░▒▓▓▓█ X=231231321 ███(Validar)██████████████▓███████
█████████████████████▓███▓▓███▓███████████████████████████████
███████████████▓▒▓▓█▓░▒▒▒▒▒▓▓▒▒█▓▓▓▓▒▒▒▒▒▒▓▓▓█████████████████
██████████████████████████████████████████████████████████████
██████████████████████████████████████████████████████████████

Starting monkey patching :D by rubn0x52.com

[+] Interceptor instalado en clases CrackMe

[*] Botón Validar presionado!
Clave encontrada
Campo: val$_$$r_easte
Clave: 6ff173f14d9384c6b897b4be810e5699ca997e18.0 <2>

[*] Botón Validar presionado!
Clave encontrada
Campo: val$_$$r_easte
```
- <1> Premain executed.
- <2> Key found!

---

## Applying dynamic attach

```shell 
rubn ⲁƛ ▸ jps                                       
4113 Main
163776 RemoteMavenServer36
212017 jar
4555 SonarLintServerCli
34763 RemoteMavenServer36
12718 RemoteMavenServer36
212061 Jps
171085 java
rubn ⲁƛ ▸ java -jar patch-lycrackme-1.0.0.jar 212017

rubn
https://rubn0x52.com
Attached to target jvm correctly
```

The PID is `212017`, and we will attach to it dynamically. ⚙️

<img width="1129" height="711" alt="image" src="https://github.com/user-attachments/assets/02cb357b-97de-41ed-909f-a960ce79c8ab" />


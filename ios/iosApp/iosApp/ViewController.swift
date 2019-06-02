import UIKit
import shared

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = PlatformKt.hello()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}

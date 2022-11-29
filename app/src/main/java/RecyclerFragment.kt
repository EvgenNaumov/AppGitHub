import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.naumov.appgithub.FakeUserRepoImpl
import com.naumov.appgithub.UsersRepo
import com.naumov.appgithub.databinding.RecyclerFragmentBinding

class RecyclerFragment : Fragment() {

    private var _binding: RecyclerFragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter: UsersAdapter = UsersAdapter()
    private val userRepo: UsersRepo = FakeUserRepoImpl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecyclerFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerButton.setOnClickListener {
            userRepo.getUsers(
                onSuccess = adapter::setData,
                onError = {
                    Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                }
            )
        }

        initRecycleeView()
    }

    private fun initRecycleeView() {
        binding.recycler.layoutManager = LinearLayoutManager(this.context)
        binding.recycler.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = RecyclerFragment()
    }
}
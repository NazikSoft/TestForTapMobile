package com.naziksoft.testfortapmobile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.naziksoft.testfortapmobile.databinding.PlayerFragmentBinding
import com.naziksoft.testfortapmobile.viewmodel.PlayerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerFragment : Fragment() {

    private lateinit var viewBinding: PlayerFragmentBinding
    private val viewModel: PlayerViewModel by viewModel()

    private val player by lazy { ExoPlayer.Builder(requireContext()).build() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = PlayerFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.exoPlayerView.player = player
    }

    private fun play(link: String){
        val mediaItem: MediaItem = MediaItem.fromUri(link)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }
}